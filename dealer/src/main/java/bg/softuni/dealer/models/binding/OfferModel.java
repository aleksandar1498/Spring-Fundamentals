package bg.softuni.dealer.models.binding;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import bg.softuni.dealer.common.enums.CategoryType;
import bg.softuni.dealer.common.enums.EngineType;
import bg.softuni.dealer.common.enums.TransmissionType;
import bg.softuni.dealer.models.service.UserServiceModel;
import bg.softuni.dealer.persistence.Model;
import bg.softuni.dealer.persistence.User;
import bg.softuni.dealer.persistence.entities.JpaModel;
import bg.softuni.dealer.persistence.entities.JpaUser;

public class OfferModel {
	private String id;
	private LocalDateTime modified;
	private LocalDateTime created;
	private Integer year;
	private TransmissionType transmission;
	private Double price;
	private Integer mileage;
	private String imageUrl;
	private EngineType engine;
	private CategoryType category;
	private String description;
	private SellerModel seller;
	private ModelModel model;
	
	public OfferModel() {
		// TODO Auto-generated constructor stub
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public LocalDateTime getModified() {
		return modified;
	}
	public void setModified(LocalDateTime modified) {
		this.modified = modified;
	}
	public LocalDateTime getCreated() {
		return created;
	}
	public void setCreated(LocalDateTime created) {
		this.created = created;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public TransmissionType getTransmission() {
		return transmission;
	}
	public void setTransmission(TransmissionType transmission) {
		this.transmission = transmission;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getMileage() {
		return mileage;
	}
	public void setMileage(Integer mileage) {
		this.mileage = mileage;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public EngineType getEngine() {
		return engine;
	}
	public void setEngine(EngineType engine) {
		this.engine = engine;
	}
	public CategoryType getCategory() {
		return category;
	}
	public void setCategory(CategoryType category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public SellerModel getSeller() {
		return seller;
	}
	public void setSeller(SellerModel seller) {
		this.seller = seller;
	}
	public ModelModel getModel() {
		return model;
	}
	public void setModel(ModelModel model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return "OfferModel [id=" + id + ", modified=" + modified + ", created=" + created + ", year=" + year
				+ ", transmission=" + transmission + ", price=" + price + ", mileage=" + mileage + ", imageUrl="
				+ imageUrl + ", engine=" + engine + ", category=" + category + ", description=" + description
				+ ", seller=" + seller + ", model=" + model + "]";
	}

	
	
	
	
	
}
