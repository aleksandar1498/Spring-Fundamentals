package bg.softuni.shopping.config;

import java.util.Arrays;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import bg.softuni.shopping.common.enums.CategoryType;
import bg.softuni.shopping.persistence.entities.JpaCategory;
import bg.softuni.shopping.persistence.repositories.CategoryRepository;

@Component
public class DataInitializer implements CommandLineRunner {
	
	@Autowired
	private CategoryRepository categoryRepo;
	@Override
	public void run(String... args) throws Exception {
		if (this.categoryRepo.count() == 0) {
			Arrays.stream(CategoryType.values()).forEach(c -> {
				this.categoryRepo.save(new JpaCategory(c,"Description for "+c.toString()));
			});
		}
	}

}
