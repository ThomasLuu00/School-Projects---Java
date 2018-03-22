package ca.on.senecac.shape;

/**
 * This exception is thrown when an invalid Rectangle parameter is passed.
 * 
 * @author Thomas
 *
 */
public class InvalidRectangleException extends InvalidParallelogramException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 263864463506058411L;

	/**
	 * InvalidRectangleException constructor. Extends Exception.
	 * Takes an exception message.
	 * 
	 * @param message
	 */
	public InvalidRectangleException(String message) {
		super(message);
	}
}