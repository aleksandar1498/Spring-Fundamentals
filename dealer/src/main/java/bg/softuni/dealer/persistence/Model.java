package bg.softuni.dealer.persistence;

import java.time.LocalDateTime;

public interface Model {
	String getName();
	String getImageUrl();
	Integer getStartYear();
	Integer getEndYear();
	LocalDateTime getCreated();
	LocalDateTime getModified();
	Brand getBrand();
}
