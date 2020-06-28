package bg.softuni.shopping.domain.binding;

import javax.validation.constraints.Size;

public class LoginUserModel {
	@Size(min = 3,max = 20 , message = "Username must be between 2 and 20 characters")
	private String username;
	@Size(min = 3,max = 20, message = "Password must be between 2 and 20 characters")
	private String password;
	
	public LoginUserModel(String username, String password) {
		this.username = username;
		this.password = password;
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
