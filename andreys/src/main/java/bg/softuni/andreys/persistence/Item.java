package bg.softuni.andreys.persistence;

import bg.softuni.andreys.common.enums.Gender;

public interface Item {
	String getName();
	String getDescription();
	Double getPrice();
	Category getCategory();
	Gender getGender();
}
