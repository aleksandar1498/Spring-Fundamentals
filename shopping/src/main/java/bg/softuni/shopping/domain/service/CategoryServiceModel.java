package bg.softuni.shopping.domain.service;

import javax.persistence.Column;

import bg.softuni.shopping.common.enums.CategoryType;

public class CategoryServiceModel {
	private CategoryType name;
	private String description;
	
	public CategoryServiceModel() {
	}

	public CategoryType getName() {
		return name;
	}

	public void setName(CategoryType name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
