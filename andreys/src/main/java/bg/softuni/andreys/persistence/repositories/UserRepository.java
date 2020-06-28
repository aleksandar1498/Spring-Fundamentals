package bg.softuni.andreys.persistence.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bg.softuni.andreys.persistence.User;
import bg.softuni.andreys.persistence.entities.JpaUser;

@Repository
public interface UserRepository extends JpaRepository<JpaUser, String> {
	Optional<User> findByUsername(String username);
}
