package bg.softuni.dealer.common.exceptions;

import javax.persistence.EntityNotFoundException;

/**
 * @author AStefanov
 *
 */
public class BrandNotFoundException extends EntityNotFoundException {
	public BrandNotFoundException(String message) {
		super(message);
	}
}
