package bg.softuni.dealer.persistence.entities;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import bg.softuni.dealer.persistence.Brand;
import bg.softuni.dealer.persistence.Model;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "models")
@NoArgsConstructor
@AllArgsConstructor
public class JpaModel extends BaseEntity implements Model {
	
	@ManyToOne(fetch = FetchType.LAZY,targetEntity = JpaBrand.class)
	@JoinColumn(name = "brand_id")
	private Brand brand;
	
	@Column
	private LocalDateTime modified;
	
	@Column
	private LocalDateTime created;
	
	@Column
	private Integer endYear;
	
	@Column
	private Integer startYear;
	
	@Column
	private String imageUrl;
	
	@Column
	private String name;

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getImageUrl() {

		return imageUrl;
	}

	@Override
	public Integer getStartYear() {

		return startYear;
	}

	@Override
	public Integer getEndYear() {

		return endYear;
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
	public Brand getBrand() {

		return brand;
	}

	public void setModified(LocalDateTime modified) {
		this.modified = modified;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public void setEndYear(Integer endYear) {
		this.endYear = endYear;
	}

	public void setStartYear(Integer startYear) {
		this.startYear = startYear;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "JpaModel [brand=" + brand + ", modified=" + modified + ", created=" + created + ", endYear=" + endYear
				+ ", startYear=" + startYear + ", imageUrl=" + imageUrl + ", name=" + name + "]";
	}

	

}
