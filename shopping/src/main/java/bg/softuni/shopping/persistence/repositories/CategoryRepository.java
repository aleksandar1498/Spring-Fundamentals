package bg.softuni.shopping.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bg.softuni.shopping.common.enums.CategoryType;
import bg.softuni.shopping.persistence.entities.JpaCategory;

@Repository
public interface CategoryRepository extends JpaRepository<JpaCategory, String> {
	JpaCategory findByName(CategoryType name);
}
