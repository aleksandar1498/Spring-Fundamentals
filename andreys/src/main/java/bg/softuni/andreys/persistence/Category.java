package bg.softuni.andreys.persistence;

import bg.softuni.andreys.common.enums.CategoryType;

public interface Category {
	CategoryType getCategoryType();
	String getDescription();
}
