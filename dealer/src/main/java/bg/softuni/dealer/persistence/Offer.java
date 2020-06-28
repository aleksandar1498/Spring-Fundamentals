package bg.softuni.dealer.persistence;

import java.time.LocalDateTime;

import bg.softuni.dealer.common.enums.CategoryType;
import bg.softuni.dealer.common.enums.EngineType;
import bg.softuni.dealer.common.enums.TransmissionType;

public interface Offer {
	String getDescription();

	EngineType getEngine();

	String getImageUrl();

	Integer getMileage();

	Double getPrice();

	TransmissionType getTransmission();

	Integer getYear();

	LocalDateTime getCreated();

	LocalDateTime getModified();

	Model getModel();

	User getSeller();

	CategoryType getCategory();
}
