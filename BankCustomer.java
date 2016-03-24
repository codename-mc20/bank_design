package BankDesignExercise;

import java.util.ArrayList;

public abstract class BankCustomer {
	private int customer_id;
	private String customer_name;
	private Address address;
	private ArrayList<BankAccount> customer_accts;
	private static int counter = 2000000;
	
	public BankCustomer(String name, Address address) {
		customer_id = counter;
		customer_name = name;
		this.address = address;
		customer_accts = new ArrayList<BankAccount>();
		counter+=7;
	}

	public int get_customer_id() {
		return customer_id;
	}
	
	public String get_customer_name() {
		return customer_name;
	}
	
	public Address get_address() {
		return address;
	}
	
	public ArrayList<BankAccount> get_customer_accts() {
		return customer_accts;
	}

	public BankAccount get_acct(int acct_num) {
		BankAccount found = null;
		
		for(BankAccount ba : customer_accts) {
			if(ba.get_acct_id() == acct_num) {
				found = ba;
			}
		}
		
		return found;
	}
	
	public abstract void add_account(BankAccount... new_accounts);
	
	private boolean acct_exist(int acct_num) {
		boolean exists = false;
		
		for(BankAccount ba : customer_accts) {
			if(ba.get_acct_id() == acct_num) {
				exists = true;
			}
		}
		
		return exists;
	}

	public abstract void alter_accounts(double amount);
	
	public void display_customer() {
		System.out.println("Customer ID: " + customer_id + "\nCustomer Name: " + customer_name);
		address.print_address();
	}
	
	public void print_account(int acct_num) {
		if(acct_exist(acct_num)) {
			get_acct(acct_num).display_account();
		}
	}
	
	public void print_accounts() {
		display_customer();
		for(BankAccount ba : customer_accts) {
			ba.display_account();
		}
	}
}
