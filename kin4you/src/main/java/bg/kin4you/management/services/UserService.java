package bg.kin4you.management.services;

import java.util.List;

import bg.kin4you.management.model.service.PatientServiceModel;

public interface UserService {
	PatientServiceModel create(PatientServiceModel user);
	List<PatientServiceModel> findAll();
	PatientServiceModel findById(String id);
}
