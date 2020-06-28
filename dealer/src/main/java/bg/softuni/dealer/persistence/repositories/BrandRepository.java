package bg.softuni.dealer.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bg.softuni.dealer.models.service.BrandServiceModel;
import bg.softuni.dealer.persistence.entities.JpaBrand;

@Repository
public interface BrandRepository extends JpaRepository<JpaBrand, String> {

	JpaBrand findByName(String name);

}
