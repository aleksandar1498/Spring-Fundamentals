package bg.softuni.shopping.domain.binding;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


import bg.softuni.shopping.common.enums.CategoryType;
import bg.softuni.shopping.persistence.entities.JpaCategory;

public class ProductAddModel {

	@Size(min = 3,max = 20 , message = "Product must be between 2 and 20 characters")
	private String name;
	
	@Size(min = 5, message = "Description must be at least 5 character")
	private String description;
	
	@Positive
	@NotNull
	private BigDecimal price;
	
	@FutureOrPresent
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private LocalDateTime neededBefore;
	
	@NotNull
	private CategoryType category;
	
	public ProductAddModel() {
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

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public LocalDateTime getNeededBefore() {
		return neededBefore;
	}

	public void setNeededBefore(LocalDateTime neededBefore) {
		this.neededBefore = neededBefore;
	}

	public CategoryType getCategory() {
		return category;
	}

	public void setCategory(CategoryType category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "ProductAddModel [name=" + name + ", description=" + description + ", price=" + price + ", neededBefore="
				+ neededBefore + ", category=" + category + "]";
	}
	
}
