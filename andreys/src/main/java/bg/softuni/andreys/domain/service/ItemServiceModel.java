package bg.softuni.andreys.domain.service;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import bg.softuni.andreys.common.enums.CategoryType;
import bg.softuni.andreys.common.enums.Gender;
import bg.softuni.andreys.persistence.Category;
import bg.softuni.andreys.persistence.entities.JpaCategory;

public class ItemServiceModel {

	private String name;

	private String description;

	private Double price;

	private CategoryServiceModel category;

	private Gender gender;

	public ItemServiceModel() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public CategoryServiceModel getCategory() {
		return category;
	}

	public void setCategory(CategoryServiceModel category) {
		this.category = category;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "ItemServiceModel [name=" + name + ", description=" + description + ", price=" + price + ", category="
				+ category + ", gender=" + gender + "]";
	}

}
