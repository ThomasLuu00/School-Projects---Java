package ca.account;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * Console application that takes Account information, serializes them to a file,
 * then deserializes them and prints them back onto the console.
 * 
 * @author Thomas
 *
 */
public final class AccountConsoleApp {
	
	private static ArrayList<Account> accounts;
	
	/**
	 * Runs serialize then deserialize right after.
	 */
	public static void run() {
		serialize();
		deserialize();
	}	
	
    /**
     * Takes user input from the console and serializes that information
     * into the file FILENAME.
     */
	private static void serialize() {
		Scanner input = new Scanner(System.in);
		boolean continueScan = true;
		accounts = new ArrayList<Account>();
		
		// Table headers.
        System.out.printf("%s%n%s%n>>> ",
			"Enter account number, first name, last name and balance.",
			"Enter 'end' to end input.");
        

        while (continueScan && input.hasNext()) {
        	// Check if the first token is an integer.
        	if (input.hasNextInt()) {
	        	try {
	        		accounts.add(new Account(input.nextInt(),
	        				input.next(), input.next(), input.nextDouble()));
	     			System.out.println("Account information added.  Total: " + accounts.size());
	     			input.nextLine();
	        	}
	        	catch (NoSuchElementException e){
	        		System.err.println("Invalid parameters. Please try again.");
	        		input.nextLine(); 
	        	}
	        	catch (InvalidAccountException e) {
	     			System.err.println(e.getMessage());
				}
	        	System.out.print(">>> ");
        	}
        	// Check for scanner termination string.
        	else if (input.nextLine().toLowerCase().trim().equals("end")) {
        		continueScan = false;
        		System.out.println("Terminating account information input...");
        	}	
        	// Invalid inputs
        	else {
        		System.err.println("Invalid input. Please try again.");
        		
        		// Pause the program so the error message has time to print.
        		try {
					TimeUnit.MILLISECONDS.sleep(100);
				} 
        		catch (InterruptedException e) {
	        		System.err.println("Interupted timeout.");
				}
	        	System.out.print(">>> ");
        	}
        }
        AccountSerializer.run(Constants.FILENAME, accounts);
        input.close();
	}
	
	/**
	 * Deserilizes Accounts from FILENAME and displays them on the console.
	 */
	private static void deserialize() {
	    accounts = AccountDeserializer.run(Constants.FILENAME);  
		System.out.printf(Constants.HEADER);
		for (Account a : accounts) {
	    	 System.out.printf(a.toString());
		}	
	}
	public static void main(String[] arg) {
		run();
	}
}
