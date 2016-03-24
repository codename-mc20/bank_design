package BankDesignExercise;

import java.text.NumberFormat;

public abstract class BankAccount {
	private int account_id;
	private double account_balance;
	private AccountType acct_type;
	private BankCustomer customer;
	private static int counter = 1000;
	
	public BankAccount(String acct_type) {
		account_id = counter;
		account_balance = 100;
		customer = null;
		if(!acct_type.equalsIgnoreCase("personal") && !acct_type.equalsIgnoreCase("business")) {
			this.acct_type = AccountType.PERSONAL;
		} else {
			this.acct_type = AccountType.valueOf(acct_type.toUpperCase());
		}
		counter+=5;
	}
	
	public int get_acct_id() {
		return this.account_id;
	}
	
	public double get_acct_bal() {
		return this.account_balance;
	}
	
	protected void set_acct_bal(double amount) {
		this.account_balance = amount;		
	}
	
	public AccountType get_acct_type() {
		return this.acct_type;
	}
	
	public BankCustomer get_customer() {
		return customer;
	}
	
	public void set_customer(BankCustomer cust) {
		this.customer = cust;
	}
	
	public void deposit(double amount) {
		if(amount >= 0) {
			set_acct_bal(this.account_balance + amount);
			System.out.println("The amount of " + NumberFormat.getCurrencyInstance().format(amount) + " has been deposited into account #" + get_acct_id() + "\n");
		} else {
			System.out.println("Invalid request: Cannot deposit a negative amount.\n");
		}
	}
	
	public abstract void withdraw(double amount);
	
	public void correction(double correction_amount) {
		if(correction_amount < 0) {
			System.out.println("Invaild request: Cannot change to a negative correction amount.\n");
		} else {
			set_acct_bal(correction_amount);
			System.out.println("The balance for account #" + get_acct_id() + " has been changed to " + correction_amount + "\n");
		}
	}
	
	public void display_account() {
		System.out.println("Acct No.: " + account_id + "\nAcct Type: " + acct_type + "\nAcct Bal.: " + NumberFormat.getCurrencyInstance().format(account_balance) + "\n");
	}
}
