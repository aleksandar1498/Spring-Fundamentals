package bg.softuni.shopping.persistence.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bg.softuni.shopping.common.enums.CategoryType;
import bg.softuni.shopping.persistence.entities.JpaProduct;

@Repository
public interface ProductRepository extends JpaRepository<JpaProduct, String> {
	
}
