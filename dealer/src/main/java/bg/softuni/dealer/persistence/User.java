package bg.softuni.dealer.persistence;

import java.time.LocalDateTime;
import java.util.Set;

public interface User {
	String getUsername();

	String getFirstName();

	String getLastName();


	String getImageUrl();

	LocalDateTime getCreated();

	LocalDateTime getModified();

	Boolean getActive();
	
	//Role getRole();

	Set<Role> getRoles();
}
