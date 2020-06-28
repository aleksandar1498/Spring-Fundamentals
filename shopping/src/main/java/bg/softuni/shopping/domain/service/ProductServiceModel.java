package bg.softuni.shopping.domain.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;

import bg.softuni.shopping.common.enums.CategoryType;

public class ProductServiceModel {
	private String id;
	
	private String name;
	
	private String description;
	
	private BigDecimal price;
	
	private LocalDateTime neededBefore;
	
	private CategoryType category;
	
	public ProductServiceModel() {
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "ProductServiceModel [name=" + name + ", description=" + description + ", price=" + price + ", neededBefore="
				+ neededBefore + ", category=" + category + "]";
	}
}
