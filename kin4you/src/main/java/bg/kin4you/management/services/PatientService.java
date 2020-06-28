package bg.kin4you.management.services;

import java.util.List;

import bg.kin4you.management.model.service.PatientServiceModel;

public interface PatientService {

	PatientServiceModel findById(String id);
	List<PatientServiceModel> findAll();
	PatientServiceModel create(PatientServiceModel user);
	PatientServiceModel remove(String id);

}
