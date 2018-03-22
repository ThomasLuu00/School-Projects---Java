package ca.on.senecac.shape;

/**
 * This exception is thrown when an invalid Circle parameter is passed.
 * 
 * @author Thomas
 */
public class InvalidCircleException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -10462989435298099L;

	/**
	 * InvalidCircleException constructor.  Extends Exception.
	 * Takes an exception message.
	 * 
	 * @param message
	 */
	public InvalidCircleException(String message) {
		super(message);
	}
}
