package bg.softuni.shopping.persistence.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import bg.softuni.shopping.persistence.entities.JpaUser;

public interface UserRepository extends JpaRepository<JpaUser, String> {

	Optional<JpaUser> findByUsername(String username);

}
