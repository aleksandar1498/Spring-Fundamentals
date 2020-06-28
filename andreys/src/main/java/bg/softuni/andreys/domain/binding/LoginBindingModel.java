package bg.softuni.andreys.domain.binding;

import javax.validation.constraints.Size;

public class LoginBindingModel {
	@Size(min = 2, message = "Username length must be more than two character")
	private String username;

	
	@Size(min = 2, message = "Password length must be more than two character")
	private String password;
	
	public LoginBindingModel() {
		// TODO Auto-generated constructor stub
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
	
	

}
