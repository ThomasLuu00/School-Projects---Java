package ca.account;

/**
 * An exception that is thrown whenever invalid parameters are passed into 
 * an Account constructor.
 * 
 * @author Thomas
 *
 */
public class InvalidAccountException extends Exception{

	private static final long serialVersionUID = 6470484123471183863L;
	
	public InvalidAccountException(String message) {
		super(message);
	}
}
