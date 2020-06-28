package bg.softuni.shopping.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import bg.softuni.shopping.common.enums.CategoryType;

@Entity
@Table(name = "categories", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class JpaCategory extends BaseEntity {
	@Enumerated(EnumType.STRING)
	private CategoryType name;

	@Column(columnDefinition = "TEXT")
	private String description;

	public JpaCategory() {
	}

	public JpaCategory(CategoryType catName, String description) {
		this.name = catName;
		this.description = description;
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

	@Override
	public String toString() {
		return "JpaCategory [name=" + name + ", description=" + description + "]";
	}

}
