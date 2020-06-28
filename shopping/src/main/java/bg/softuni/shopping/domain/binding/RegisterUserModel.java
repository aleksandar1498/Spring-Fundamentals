package bg.softuni.shopping.domain.binding;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class RegisterUserModel {
	
	@NotEmpty(message = "The username cannot be empty")
	@Size(min = 3,max = 20 , message = "Username must be between 2 and 20 characters")
	private String username;
	
	@Size(min = 3, max = 20, message = "Password must be between 2 and 20 characters")
	private String password;
	
	private String confirmPassword;
	
	@Email
	private String email;

	public RegisterUserModel() {
	}
	
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
	
	



}
