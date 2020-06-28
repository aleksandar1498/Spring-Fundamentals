package bg.softuni.dealer.common.exceptions;

public enum ErrorMessages {
	BRAND_NOT_FOUND_BY_NAME("A brand with this name does not exist");
	
	private final String message;
	
	private ErrorMessages(String message) {
		this.message = message;
	}
}
