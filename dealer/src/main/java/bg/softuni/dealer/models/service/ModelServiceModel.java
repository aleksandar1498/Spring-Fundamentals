package bg.softuni.dealer.models.service;

import java.time.LocalDateTime;

public class ModelServiceModel {
	private String id;
	
	private BrandServiceModel brand;

	private LocalDateTime modified;

	private LocalDateTime created;

	private Integer endYear;

	private Integer startYear;

	private String imageUrl;

	private String name;

	public ModelServiceModel() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BrandServiceModel getBrand() {
		return brand;
	}

	public void setBrand(BrandServiceModel brand) {
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
		return "ModelServiceModel [brand=" + brand + ", modified=" + modified + ", created=" + created + ", endYear="
				+ endYear + ", startYear=" + startYear + ", imageUrl=" + imageUrl + ", name=" + name + "]";
	}

}
