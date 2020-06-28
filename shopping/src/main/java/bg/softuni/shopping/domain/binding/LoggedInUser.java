package bg.softuni.shopping.domain.binding;

import java.util.Set;


public class LoggedInUser {

	private static final long serialVersionUID = 5760871282417018588L;

	private String id; 
	
	private String username;

	private String email;

	public LoggedInUser() {
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
