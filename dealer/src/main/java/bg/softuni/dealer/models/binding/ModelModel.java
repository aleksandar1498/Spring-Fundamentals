package bg.softuni.dealer.models.binding;

import java.time.LocalDateTime;

import javax.persistence.Column;

import bg.softuni.dealer.models.service.BrandServiceModel;
import bg.softuni.dealer.persistence.Brand;

public class ModelModel {
	private String id;
	
	private BrandModel brand;
	
	private LocalDateTime modified;
	
	private LocalDateTime created;
	
	private Integer endYear;
	
	private Integer startYear;
	
	private String imageUrl;
	
	private String name;
	
	public ModelModel() {
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	public BrandModel getBrand() {
		return brand;
	}

	public void setBrand(BrandModel brand) {
		this.brand = brand;
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

	public Integer getEndYear() {
		return endYear;
	}

	public void setEndYear(Integer endYear) {
		this.endYear = endYear;
	}

	public Integer getStartYear() {
		return startYear;
	}

	public void setStartYear(Integer startYear) {
		this.startYear = startYear;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "ModelModel [id=" + id + ", brand=" + brand + ", modified=" + modified + ", created=" + created
				+ ", endYear=" + endYear + ", startYear=" + startYear + ", imageUrl=" + imageUrl + ", name=" + name
				+ "]";
	}

	
	
	
}
