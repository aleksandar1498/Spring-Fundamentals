package bg.softuni.shopping.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "users",uniqueConstraints = @UniqueConstraint(columnNames = "username"))
public class JpaUser extends BaseEntity {
	@Column
	private String username;
	
	@Column
	private String password;
	
	@Column
	private String email;

	public JpaUser() {
		// needed by JPA
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
