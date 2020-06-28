package bg.softuni.dealer.models.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;


public class UserServiceModel {
	private String id;
	private String username;
	private String firstName;
	private String lastName;
	private String imageUrl;
	private boolean active;
	private LocalDateTime created;
	private LocalDateTime modified;
	
	public UserServiceModel() {
	}
	
	

	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public LocalDateTime getModified() {
		return modified;
	}

	public void setModified(LocalDateTime modified) {
		this.modified = modified;
	}

	@Override
	public String toString() {
		return "UserRegisterModel [username=" + username + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", imageUrl=" + imageUrl + "]";
	}
}
