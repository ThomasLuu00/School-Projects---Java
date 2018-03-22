package ca.on.senecac.shape;

/**
 * This exception is thrown when an invalid Triangle parameter is passed.
 * 
 * @author Thomas
 *
 */
public class InvalidTriangleException extends Exception {


	/**
	 * 
	 */
	private static final long serialVersionUID = 9011154755715820634L;

	/**
	 * InvalidTriangleException constructor. Extends Exception.
	 * Takes an exception message.
	 * 
	 * @param message
	 */
	public InvalidTriangleException(String message) {
		super(message);
	}
}