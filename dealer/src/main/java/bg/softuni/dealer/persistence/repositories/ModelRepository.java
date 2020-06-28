package bg.softuni.dealer.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import bg.softuni.dealer.persistence.entities.JpaModel;

public interface ModelRepository extends JpaRepository<JpaModel, String> {

}
