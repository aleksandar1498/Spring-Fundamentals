package bg.softuni.andreys.service;

import bg.softuni.andreys.common.enums.CategoryType;
import bg.softuni.andreys.domain.service.CategoryServiceModel;

public interface CategoryService {
	CategoryServiceModel findCategoryBy(CategoryType category);
}
