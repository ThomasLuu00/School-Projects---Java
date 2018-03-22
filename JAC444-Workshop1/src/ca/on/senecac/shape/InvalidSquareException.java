package ca.on.senecac.shape;

/**
 * This exception is thrown when an invalid Square parameter is passed.
 * 
 * @author Thomas
 *
 */
public class InvalidSquareException extends InvalidRectangleException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8262709842668836285L;

	/**
	 * InvalidSquareException constructor.  Extends Exception.
	 * Takes an exception message.
	 * 
	 * @param message
	 */
	public InvalidSquareException(String message) {
		super(message);
	}
}