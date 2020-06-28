package bg.softuni.shopping.persistence.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name = "products",uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class JpaProduct extends BaseEntity {

	@Column
	private String name;
	
	@Column
	private String description;
	
	@Column
	private BigDecimal price;
	
	@Column
	private LocalDateTime neededBefore;
	
	@ManyToOne(optional = false,fetch = FetchType.LAZY)
	private JpaCategory category;
	
	public JpaProduct() {
		// needed by jpa
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

	public JpaCategory getCategory() {
		return category;
	}

	public void setCategory(JpaCategory category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "JpaProduct [name=" + name + ", description=" + description + ", price=" + price + ", neededBefore="
				+ neededBefore + ", category=" + category + "]";
	}
	
	
	
	
}
