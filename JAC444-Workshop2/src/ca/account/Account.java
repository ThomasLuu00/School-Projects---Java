package ca.account;

import java.io.Serializable;

/**
 * Account class for workshop 2.
 * 
 * @author Thomas
 *
 */
public class Account implements Serializable{

	private static final long serialVersionUID = 3916553638107202598L;
	private int account = 0;
	private String firstName = "";
	private String lastName = "";
	private double balance = 0;
	
	
	public Account() throws InvalidAccountException{
		this(0,"","",0);
	}
	
	public Account(int accountNumber, String firstName, String lastName, double balance) 
			throws InvalidAccountException{
		if (accountNumber <= 0) {
			throw new InvalidAccountException("Account number is not greater than 0");
		}
		else {
			this.account = accountNumber;
			this.firstName = firstName;
			this.lastName = lastName;
			this.balance = balance;
		}
	}
	
	/**
	 * Returns the string representation of this Account.
	 * 
	 * @return string representation of the Account.
	 */
	public String toString() {
		return String.format("%-10d%-12s%-12s%10.2f%n", 
				this.getAccountNumber(), this.getFirstName(), 
				this.getLastName(), this.getBalance());
	}
	
	/**
	 * Returns whether this Account is the same as the recieved other Account.
	 * Two accounts are equal if all instance variables are the same.
	 * 
	 * @return a boolean of whether this and the other Account are the same.
	 */
	public boolean equals(Account other) {
		return (
				this.getAccountNumber() == other.getAccountNumber() &&
				this.getFirstName() == other.getFirstName() &&
				this.getLastName() == other.getLastName() &&
				this.getBalance() == other.getBalance()
				);
	}
	
	/**
	 * Sets a new first name for this Account.
	 * 
	 * @param fName the new first name for this Account.
	 */
	public void setFirstName(String fName) {
		this.firstName = fName;
	}

	/**
	 * Returns the first name for this Account.
	 * 
	 * @return first name for this Account.
	 */
	public String getFirstName() {
		return this.firstName;
	}

	/**
	 * Sets a new last name for this Account.
	 * 
	 * @param lName the new last name for this Account.
	 */
	public void setLastName(String lName) {
		this.lastName = lName;
	}

	/**
	 * Returns the last name for this Account.
	 * 
	 * @return last name for this Account.
	 */
	public String getLastName() {
		return this.lastName;
	}

	/**
	 * Sets a new balance for this Account.
	 * 
	 * @param newBalance the new balance for this Account.
	 */
	public void setBalance(double newBalance) {
		this.balance = newBalance;
	}

	/**
	 * Returns the balance for this Account.
	 * 
	 * @return balance for this Account.
	 */
	public double getBalance() {
		return this.balance;
	}
	
	/**
	 * Sets a new account number for this Account. 
	 * Account numbers must be greater than 0.
	 * 
	 * @param newAccountNumber the new number for this Account.
	 */
	public void setAccountNumber(int newAccountNumber) {
		if (newAccountNumber > 0) {
			this.balance = newAccountNumber;
		}
	}

	/**
	 * Returns the account number for this Account.
	 * 
	 * @return account number for this Account.
	 */
	public int getAccountNumber() {
		return this.account;
	}
	
	
	
}
