package bg.softuni.andreys.persistence;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import bg.softuni.andreys.common.enums.CategoryType;
import bg.softuni.andreys.persistence.entities.JpaCategory;
import bg.softuni.andreys.persistence.repositories.CategoryRepository;

@Component
public class DataInitialization implements CommandLineRunner {
	private CategoryRepository categoryRepo;

	@Autowired
	public DataInitialization(CategoryRepository categoryRepo) {
		this.categoryRepo = categoryRepo;
	}

	@Override
	public void run(String... args) throws Exception {
		
		if (this.categoryRepo.count() == 0) {
			this.categoryRepo.saveAll(Set.of(new JpaCategory(CategoryType.DENIM, "Denim"),
					new JpaCategory(CategoryType.JACKET, "Jacket"), new JpaCategory(CategoryType.SHIRT, "Shirt"),
					new JpaCategory(CategoryType.SHORTS, "Shorts")));
		}

	}

}
