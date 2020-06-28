package bg.softuni.dealer.persistence.entities;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import bg.softuni.dealer.persistence.Role;
import bg.softuni.dealer.persistence.User;

@Entity
@Table(name = "users",uniqueConstraints = @UniqueConstraint(columnNames = "username"))
public class JpaUser extends BaseEntity implements User {

	@ElementCollection(targetClass = JpaRole.class)
	private Set<Role> roles;
	
	@Column
	private Boolean active;
	
	@Column
	private LocalDateTime modified;
	
	@Column
	private LocalDateTime created;
	
	@Column
	private String imageUrl;
	
	@Column
	private String lastName;
	
	@Column
	private String firstName;
	
	@Column
	private String username;

	public JpaUser() {
		
	}
	
	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public String getFirstName() {
		return firstName;
	}

	@Override
	public String getLastName() {
		return lastName;
	}

	@Override
	public String getImageUrl() {
		return imageUrl;
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
	public Boolean getActive() {
		return active;
	}

	@Override
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public void setModified(LocalDateTime modified) {
		this.modified = modified;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	
}
