package ca.account;

/**
 * Constants for the ca.account package.
 * 
 * @author Thomas
 *
 */
public final class Constants {
	private Constants(){}
	public static final String FILENAME = "test.txt";
	public static final String HEADER = String.format("%-10s%-12s%-12s%10s%n", 
			"Account","First Name", "Last Name", "Balance");
}
