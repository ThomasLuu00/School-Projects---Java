package ca.account;

import java.io.FileNotFoundException;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/***
 * A class that assists in deserializing Accounts from a file.
 * 
 * @author Thomas
 *
 */
public final class AccountDeserializer {
	private static ObjectInputStream input;
	
	/***
	 * Deserialize Accounts from the passed file path and then returns an
	 * ArrayList with those Accounts.
	 * 
	 * @param fileName path to ObjectFile
	 * @return ArrayList containing the deserialized accounts.
	 */
	public static ArrayList<Account> run(String fileName) {
		openFile(fileName);
		ArrayList<Account> accounts = deserializeAccounts();
		closeFile();
		return accounts;
	}

	/**
	 * Opens fileName for the ObjectInputStream input for deserialization.
	 * 
	 * @param fileName path to file
	 */
	private static void openFile(String fileName) {
		try {
			input = new ObjectInputStream(new FileInputStream(fileName));
		} 
		catch (FileNotFoundException e) {
			System.err.println("File not found.");
		} 
		catch (IOException e) {
			System.err.println("Error opening file.");
		}
	}
	
	/**
	 * Closes the ObjectInputStream input. 
	 */
	private static void closeFile() {
		try {
			input.close();
		} 
		catch (IOException e) {
			System.err.println("Error closing file.");
		}
	}
	
	/**
	 * Deserializes Accounts from ObjectInputStream input and 
	 * returns an ArrayList of the deserialized accounts.
	 * 
	 * @return ArrayList of Accounts
	 */
	private static ArrayList<Account> deserializeAccounts() {	
		ArrayList<Account> accounts = new ArrayList<Account>();
		try {
		     while (true){
		    	 Account record = (Account) input.readObject(); 
		    	 accounts.add(record);
		 	}
 		}
		catch (EOFException e) {
 			System.out.println("Record deserialization complete.");
 		}
		catch (ClassNotFoundException e) {
 		    System.err.println("Invalid object type. Terminating.");
 		}
		catch (IOException e) {
 			System.err.println("Error reading from file. Terminating.");
	 	}
		return accounts;
	}	
}
