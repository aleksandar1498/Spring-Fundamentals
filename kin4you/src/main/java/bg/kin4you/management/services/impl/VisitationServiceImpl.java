package bg.kin4you.management.services.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bg.kin4you.management.model.service.PatientServiceModel;
import bg.kin4you.management.model.service.VisitationServiceModel;
import bg.kin4you.management.persistence.entities.JpaPatient;
import bg.kin4you.management.persistence.entities.JpaVisitation;
import bg.kin4you.management.persistence.repositories.PatientRepository;
import bg.kin4you.management.persistence.repositories.VisitationRepository;
import bg.kin4you.management.services.PatientService;
import bg.kin4you.management.services.VisitationService;

@Service
public class VisitationServiceImpl implements VisitationService {

	private ModelMapper mapper;
	private PatientService patientService;
	private PatientRepository patientRepo;
	private VisitationRepository visitRepo;

	@Autowired
	public VisitationServiceImpl(ModelMapper mapper, PatientService patientService, VisitationRepository visitRepo,PatientRepository patientRepo) {
		this.mapper = mapper;
		this.patientService = patientService;
		this.visitRepo = visitRepo;
		this.patientRepo = patientRepo;
	}

	@Override
	public List<VisitationServiceModel> findVisitationsByPatientId(String id) {
		PatientServiceModel patient = this.patientService.findById(id);
		if (patient == null) {
			throw new IllegalArgumentException("Patient not found");
		}
		return this.visitRepo.findByPatient(this.mapper.map(patient, JpaPatient.class)).stream()
				.map(v -> this.mapper.map(v, VisitationServiceModel.class)).collect(Collectors.toList());
	}

	@Override
	public VisitationServiceModel findVisitationById(String id) {
		JpaVisitation visitation = this.visitRepo.findById(id).orElse(null);
		if(visitation == null) {
			throw new IllegalArgumentException("Visitation not found");
		}
		
		return this.mapper.map(visitation,VisitationServiceModel.class);
	}

	@Override
	public List<VisitationServiceModel> findVisitationsByDate(LocalDateTime date) {
		return visitRepo.findByDate(date).stream().map(v -> this.mapper.map(v,VisitationServiceModel.class)).collect(Collectors.toList());
	}

	@Override
	public VisitationServiceModel create(VisitationServiceModel visitation) {
		JpaVisitation visitationToSave = this.mapper.map(visitation,JpaVisitation.class);
			
		JpaPatient patientForVisitation = this.patientRepo.findById(visitation.getPatient().getId()).orElse(null);
		
		if(patientForVisitation == null) {
			throw new IllegalArgumentException("A patient with this id does not exists");
		}
		visitationToSave.setPatient(patientForVisitation);
		return this.mapper.map(this.visitRepo.save(visitationToSave),VisitationServiceModel.class);
	}

}
