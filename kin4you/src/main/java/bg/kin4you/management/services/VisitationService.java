package bg.kin4you.management.services;

import java.time.LocalDateTime;
import java.util.List;

import bg.kin4you.management.model.service.VisitationServiceModel;

public interface VisitationService {
	List<VisitationServiceModel> findVisitationsByPatientId(String id);
	VisitationServiceModel findVisitationById(String id);
	List<VisitationServiceModel> findVisitationsByDate(LocalDateTime date);
	VisitationServiceModel create(VisitationServiceModel visitation);
}
