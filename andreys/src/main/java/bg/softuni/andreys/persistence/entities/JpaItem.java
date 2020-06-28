package bg.softuni.andreys.persistence.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import bg.softuni.andreys.common.enums.Gender;
import bg.softuni.andreys.persistence.Category;
import bg.softuni.andreys.persistence.Item;


@Entity
@Table(name = "items",uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class JpaItem extends BaseEntity implements Item {

	@Column
	private String name;
	
	@Column
	private String description;
	
	@Column
	private Double price;

	@ManyToOne(targetEntity = JpaCategory.class,optional = false,fetch = FetchType.LAZY)
	private Category category;

	@Enumerated(EnumType.STRING)
	private Gender gender;

	public JpaItem() {

	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String getDescription() {
		return this.description;
	}

	@Override
	public Double getPrice() {
		return this.price;
	}

	@Override
	public Category getCategory() {
		return this.category;
	}

	@Override
	public Gender getGender() {
		return this.gender;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "JpaItem [name=" + name + ", description=" + description + ", price=" + price + ", category=" + category
				+ ", gender=" + gender + "]";
	}
	
	
	

}
