package bg.kin4you.management.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bg.kin4you.management.persistence.entities.JpaPatient;

@Repository
public interface PatientRepository extends JpaRepository<JpaPatient, String> {

}
