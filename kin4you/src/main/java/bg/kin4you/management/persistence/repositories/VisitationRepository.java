package bg.kin4you.management.persistence.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bg.kin4you.management.persistence.Patient;
import bg.kin4you.management.persistence.entities.JpaVisitation;

@Repository
public interface VisitationRepository extends JpaRepository<JpaVisitation, String> {
	List<JpaVisitation> findByPatient(Patient patient);
	List<JpaVisitation> findByDate(LocalDateTime date);
	
	
}
