package bg.softuni.dealer.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bg.softuni.dealer.persistence.entities.JpaUser;

@Repository
public interface UserRepository extends JpaRepository<JpaUser, String> {

}
