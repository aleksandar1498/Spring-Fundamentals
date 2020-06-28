package bg.kin4you.management.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bg.kin4you.management.model.service.PatientServiceModel;
import bg.kin4you.management.persistence.entities.JpaPatient;
import bg.kin4you.management.persistence.entities.JpaUser;
import bg.kin4you.management.persistence.repositories.PatientRepository;
import bg.kin4you.management.services.PatientService;
import bg.kin4you.management.services.UserService;


@Service
public class PatientServiceImpl implements PatientService{
	
	private ModelMapper mapper;
	private PatientRepository patientRepo;
	
	
	@Autowired
	public PatientServiceImpl(ModelMapper mapper, PatientRepository patientRepo) {
		this.mapper = mapper;
		this.patientRepo = patientRepo;
	}
	
	@Override
	public PatientServiceModel create(PatientServiceModel user) {
		
		JpaUser persisted = this.patientRepo.save(mapper.map(user,JpaPatient.class));
		
		return mapper.map(persisted,PatientServiceModel.class);
		
	}
	@Override
	public List<PatientServiceModel> findAll() {
		return this.patientRepo.findAll().stream().map(u -> mapper.map(u,PatientServiceModel.class)).collect(Collectors.toList());
	}
	@Override
	public PatientServiceModel findById(String id) {
		JpaUser user =  this.patientRepo.findById(id).orElse(null);
		if(user == null) {
			return null;
		}
		return mapper.map(user,PatientServiceModel.class);
	}

	@Override
	public PatientServiceModel remove(String id) {
		JpaPatient patientToRemove = this.patientRepo.findById(id).orElse(null);
		if(patientToRemove == null) {
			throw new EntityNotFoundException("A patient with this id is not found");
		}
		this.patientRepo.delete(patientToRemove);
		return this.mapper.map(patientToRemove,PatientServiceModel.class);
	}
	
	

}
