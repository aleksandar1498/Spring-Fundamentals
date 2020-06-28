package bg.softuni.andreys.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import bg.softuni.andreys.common.enums.CategoryType;
import bg.softuni.andreys.persistence.Category;


@Entity
@Table(name = "categories")
public class JpaCategory extends BaseEntity implements Category {

	@Enumerated(EnumType.STRING)
	private CategoryType categoryType;
	
	@Column(columnDefinition = "TEXT")
	private String description;

	public JpaCategory() {
	}
	
	

	public JpaCategory(CategoryType categoryType, String description) {
		this.categoryType = categoryType;
		this.description = description;
	}



	@Override
	public CategoryType getCategoryType() {
		return this.categoryType;
	}

	@Override
	public String getDescription() {
		return this.description;
	}

	public void setCategoryType(CategoryType categoryType) {
		this.categoryType = categoryType;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
