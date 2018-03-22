package ca.account;

import java.io.*;
import java.util.ArrayList;

/**
 * A class that assists in serializing Accounts to a file.
 * 
 * @author Thomas
 *
 */
public final class AccountSerializer {
	private static ObjectOutputStream output;
	
	/**
	 * Serializes Accounts from accounts to filename
	 * 
	 * @param fileName path to ObjectFile
	 * @param accounts ArrayList of Accounts to serialize
	 */
	public static void run(String fileName, ArrayList<Account> accounts) {
		openFile(fileName);
		serializeAccounts(accounts);
		closeFile();
	}
	
	/**
	 * Opens file for the ObjectOutputStream output for serialization.
	 * 
	 * @param fileName path to file
	 */
	private static void openFile(String fileName) {
		try {
			output = new ObjectOutputStream(new FileOutputStream(fileName));
		} 
		catch (FileNotFoundException e) {
 			System.err.println("File not found.");
		}
 		catch (IOException e) {
 			System.err.println("Error opening file.");
		}
	}
	
	/**
	 * Closes the ObjectOutputStream output. 
	 */
	private static void closeFile() {
		try {
			output.close();
		} 
		catch (IOException e) {
			System.err.println("Error closing file.");
		}
	}

	/**
	 * Serializes Accounts to the file via the ObjectOutputStream 
	 * output from the ArrayList accounts.
	 * 
	 * @param ArrayList of Accounts
	 */
	private static void serializeAccounts(ArrayList<Account> accounts){
		try {
			for (Account a : accounts) {
				output.writeObject(a);
			}
		} 
		catch (IOException e) {
			System.err.println("Error writing to file.");
		}
	}
}