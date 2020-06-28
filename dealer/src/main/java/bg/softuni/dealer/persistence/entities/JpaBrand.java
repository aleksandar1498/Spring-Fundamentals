package bg.softuni.dealer.persistence.entities;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.PastOrPresent;

import bg.softuni.dealer.persistence.Brand;
import bg.softuni.dealer.persistence.Model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "brands")
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class JpaBrand extends BaseEntity implements Brand {
	@Column
	private String name;
	@Column
	@PastOrPresent
	private LocalDateTime created;
	@Column
	@PastOrPresent
	private LocalDateTime modified;
	
	@OneToMany(mappedBy = "brand",fetch = FetchType.LAZY,cascade = CascadeType.ALL,targetEntity = JpaModel.class)
	private List<Model> models;

	@Override
	public String getName() {
		return name;
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
	public List<Model> getModels() {
		return models;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public void setModified(LocalDateTime modified) {
		this.modified = modified;
	}

	public void setModels(List<Model> models) {
		this.models = models;
	}
	

}
