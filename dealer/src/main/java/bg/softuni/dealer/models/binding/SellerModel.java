package bg.softuni.dealer.models.binding;

public class SellerModel {
	private String id;
	private String username;
	private String firstName;
	private String lastName;
	private String imageUrl;

	public SellerModel() {
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

	@Override
	public String toString() {
		return "SellerModel [id=" + id + ", username=" + username + ", firstName=" + firstName + ", lastName="
				+ lastName + ", imageUrl=" + imageUrl + "]";
	}

	

}
