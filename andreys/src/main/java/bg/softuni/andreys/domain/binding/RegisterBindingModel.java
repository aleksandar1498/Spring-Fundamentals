package bg.softuni.andreys.domain.binding;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class RegisterBindingModel {

	public RegisterBindingModel() {
		// TODO Auto-generated constructor stub
	}

	@Size(min = 2, message = "Username length must be more than two character")
	private String username;

	
	@Size(min = 2, message = "Password length must be more than two character")
	private String password;

	@NotEmpty(message = "Confirm Password cannot be empty")
	private String confirmPassword;

	@Email(message = "Email must be valid")
	@NotEmpty(message ="Email cannot be empty")
	private String email;

	@Min(value = 0,message = "Budget must be positive")
	@NotNull(message = "Budget cannot be null")
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