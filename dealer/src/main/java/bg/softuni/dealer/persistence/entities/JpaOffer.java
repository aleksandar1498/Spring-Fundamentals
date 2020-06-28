package bg.softuni.dealer.persistence.entities;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

import bg.softuni.dealer.common.enums.CategoryType;
import bg.softuni.dealer.common.enums.EngineType;
import bg.softuni.dealer.common.enums.TransmissionType;
import bg.softuni.dealer.persistence.Model;
import bg.softuni.dealer.persistence.Offer;
import bg.softuni.dealer.persistence.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "offers")
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class JpaOffer extends BaseEntity implements Offer {

	@Column
	private LocalDateTime modified;
	@Column
	private LocalDateTime created;
	@Column
	private Integer year;
	@Enumerated(EnumType.STRING)
	private TransmissionType transmission;
	@Column
	private Double price;
	@Column
	private Integer mileage;
	@Column(columnDefinition = "TEXT")
	private String imageUrl;
	@Enumerated(EnumType.STRING)
	private EngineType engine;
	@Enumerated(EnumType.STRING)
	private CategoryType category;
	@Column(columnDefinition = "TEXT")
	private String description;
	
	@ManyToOne(targetEntity = JpaUser.class,fetch = FetchType.LAZY)
	private User seller;
	
	@ManyToOne(targetEntity = JpaModel.class,fetch = FetchType.LAZY)
	private Model model;

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public EngineType getEngine() {
		return engine;
	}

	@Override
	public String getImageUrl() {
		return imageUrl;
	}

	@Override
	public Integer getMileage() {
		return mileage;
	}

	@Override
	public Double getPrice() {
		return price;
	}

	@Override
	public TransmissionType getTransmission() {
		return transmission;
	}

	@Override
	public Integer getYear() {
		return year;
	}

	@Override
	public LocalDateTime getCreated() {
		return created;
	}

	@Override
	public LocalDateTime getModified() {
		return modified;
	}

	@Override
	public Model getModel() {
		return model;
	}

	@Override
	public User getSeller() {
		return seller;
	}
	
	@Override
	public CategoryType getCategory() {
		return category;
	}

	public void setCategory(CategoryType category) {
		this.category = category;
	}

	public void setModified(LocalDateTime modified) {
		this.modified = modified;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public void setTransmission(TransmissionType transmission) {
		this.transmission = transmission;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public void setMileage(Integer mileage) {
		this.mileage = mileage;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public void setEngine(EngineType engine) {
		this.engine = engine;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setSeller(User seller) {
		this.seller = seller;
	}

	public void setModel(Model model) {
		this.model = model;
	}
	
	
	

}
