package bg.softuni.andreys.domain.service;

public class UserRegisterServiceModel {
	public UserRegisterServiceModel() {
		// TODO Auto-generated constructor stub
	}


	private String username;

	private String password;

	private String confirmPassword;

	private String email;

	private Integer budget;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getBudget() {
		return budget;
	}

	public void setBudget(Integer budget) {
		this.budget = budget;
	}
}