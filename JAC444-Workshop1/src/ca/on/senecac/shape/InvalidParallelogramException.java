package ca.on.senecac.shape;

/**
 * This exception is thrown when an invalid Parallelogram parameter is passed.
 * 
 * @author Thomas
 */
public class InvalidParallelogramException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6117132559507052498L;

	/**
	 * InvalidParallelogramException constructor. Extends Exception.
	 * Takes an exception message.
	 * 
	 * @param message
	 */
	public InvalidParallelogramException(String message) {
		super(message);
	}
}