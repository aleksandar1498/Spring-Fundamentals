package bg.softuni.andreys.utils;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bg.softuni.andreys.common.enums.CategoryType;
import bg.softuni.andreys.domain.service.CategoryServiceModel;
import bg.softuni.andreys.service.CategoryService;

@Component
public class EnumToServiceConverter implements Converter<CategoryType, CategoryServiceModel> {
	@Autowired
	private CategoryService categoryService;

	@Override
	public CategoryServiceModel convert(MappingContext<CategoryType, CategoryServiceModel> context) {
		if (context.getSource() == null) {
			return null;
		}
		return this.categoryService.findCategoryBy(context.getSource());
	}



}
