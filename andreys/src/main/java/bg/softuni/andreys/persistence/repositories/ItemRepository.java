package bg.softuni.andreys.persistence.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bg.softuni.andreys.persistence.entities.JpaItem;

@Repository
public interface ItemRepository extends JpaRepository<JpaItem, String> {

	Optional<JpaItem> findByName(String name);
	
}