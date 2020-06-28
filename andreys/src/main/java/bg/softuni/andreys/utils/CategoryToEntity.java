package bg.softuni.andreys.utils;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bg.softuni.andreys.common.enums.CategoryType;
import bg.softuni.andreys.domain.service.CategoryServiceModel;
import bg.softuni.andreys.persistence.Category;
import bg.softuni.andreys.persistence.entities.JpaCategory;
import bg.softuni.andreys.persistence.repositories.CategoryRepository;
import bg.softuni.andreys.service.CategoryService;

@Component
public class CategoryToEntity implements Converter<CategoryServiceModel, Category> {
	@Autowired
	private CategoryRepository repo;

	@Override
	public Category convert(MappingContext<CategoryServiceModel, Category> context) {
		if (context.getSource() == null) {
			return null;
		}
		return this.repo.findByCategoryType(context.getSource().getCategoryType()).orElse(null);
	}

}
