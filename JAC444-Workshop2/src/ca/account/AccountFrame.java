package ca.account;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * The JFrame that serves at an interface for Serializing and Deserializing 
 * Accounts.
 * 
 * @author Thomas
 *
 */
@SuppressWarnings("serial")
public final class AccountFrame extends JFrame {

	private ArrayList<Account> accounts = new ArrayList<Account>();
	private final JTextField accountNumber;
	private final JTextField firstName;
	private final JTextField lastName;
	private final JTextField balance; 

	private final JTextArea displayArea;

	private final JButton addAccountButton; 
	private final JButton listAccountsButton;

	/**
	 * Generate the interface
	 * 
	 */
	public AccountFrame()
	{
		super("New Account");
		setLayout(new FlowLayout()); 

		// Serialize Panel
		JPanel serializePanel = new JPanel();
		serializePanel.setLayout(new BoxLayout(serializePanel, BoxLayout.PAGE_AXIS));

		// -- Account Number
		serializePanel.add(new JLabel("Account Number"));
		accountNumber = new JTextField(5);
		serializePanel.add(accountNumber);

		// -- First Name
		serializePanel.add(new JLabel("First Name"));
		firstName = new JTextField(5);
		serializePanel.add(firstName);

		// -- Last Name
		serializePanel.add(new JLabel("Last Name"));
		lastName = new JTextField(5);
		serializePanel.add(lastName);

		// -- Balance
		serializePanel.add(new JLabel("Balance"));
		balance = new JTextField(5);
		serializePanel.add(balance);

		// -- Add Account Button
		addAccountButton = new JButton("Add Account"); 
		serializePanel.add(addAccountButton);
		Serialize handler = new Serialize();
		addAccountButton.addActionListener(handler);

		add(serializePanel);

		// Deserialize Panel
		JPanel deserializePanel = new JPanel();
		deserializePanel.setLayout(new BoxLayout(deserializePanel, BoxLayout.PAGE_AXIS));	     

		// -- Display Area
		displayArea = new JTextArea(10, 60);
		displayArea.setEditable(false);
		displayArea.setFocusable(false);
		displayArea.setFont(new Font("Courier New", Font.PLAIN, 12));
		displayArea.setLineWrap(true);
		displayArea.setWrapStyleWord(true);
		deserializePanel.add(displayArea);

		// -- Deserialize Button
		listAccountsButton = new JButton("List Accounts");
		deserializePanel.add(listAccountsButton); 
		Deserialize deserializeHandler = new Deserialize();
		listAccountsButton.addActionListener(deserializeHandler);

		add(deserializePanel);
		this.getRootPane().setDefaultButton(addAccountButton);
	}

	/**
	 * Inner class that handles the implementation for the 
	 * 'Add Account' button.
	 *
	 */
	private class Serialize implements ActionListener 
	{
		public void actionPerformed(ActionEvent event)
		{
			try {
				Account account = new Account(Integer.parseInt(accountNumber.getText()), 
						firstName.getText(),lastName.getText(),Double.parseDouble(balance.getText()));
				accounts.add(account);
				AccountSerializer.run(Constants.FILENAME, accounts);
				displayArea.setText(Constants.HEADER);
				displayArea.append(account.toString() + "Account added.");
				
				// Clear text fields.
				accountNumber.setText("");
				firstName.setText("");
				lastName.setText("");
				balance.setText("");
			} 
		
			catch (NumberFormatException e) {
				displayArea.setText("Account number and balance must be numeric.");
			} 
			catch (InvalidAccountException e) {
				displayArea.setText(e.getMessage());
			}
		}
	} 

	/**
	 * Inner class that handles the implementation for the 
	 * 'List Accounts' button.
	 *
	 */
	private class Deserialize implements ActionListener 
	{
		public void actionPerformed(ActionEvent event)
		{
			displayArea.setText(Constants.HEADER);
			ArrayList<Account> accounts = AccountDeserializer.run(Constants.FILENAME);
			for (Account a: accounts) {
				displayArea.append(a.toString());
			}
		}
	}
	/**
	 * Executes the program.
	 * 
	 * @param args dummy variables.
	 */
	public static void main(String[] args)
	{ 
		AccountFrame accountFrame = new AccountFrame(); 
		accountFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		accountFrame.setSize(700,300);
		accountFrame.setResizable(false);
		accountFrame.setVisible(true); 
	} 
}
