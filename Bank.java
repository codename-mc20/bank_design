package BankDesignExercise;

import java.util.ArrayList;

public class Bank {
	private String bank_name;
	private String bank_manager;
	private Address bank_address;
	private ArrayList<BankAccount> accounts;
	private ArrayList<BankCustomer> customers;
	
	public Bank(String name, String manager, Address address) {
		bank_name = name;
		bank_manager = manager;
		bank_address = address;
		accounts = new ArrayList<BankAccount>();
		customers = new ArrayList<BankCustomer>();
	}

	public String get_bank_manager() {
		return bank_manager;
	}

	public String get_bank_name() {
		return bank_name;
	}
	
	public String get_bank_address() {
		return bank_address.get_address();
	}
	
	public ArrayList<BankAccount> get_accounts() {
		return accounts;
	}
	
	public ArrayList<BankCustomer> get_customers() {
		return customers;
	}
	
	public void add_account(BankAccount... accounts) {
		for(BankAccount a : accounts) {
			if(!account_exist(a.get_acct_id())) {
				get_accounts().add(a);
				get_customers().add(a.get_customer());
			}
		}
	}
	
	public void add_customer(BankCustomer... customers) {
		for(BankCustomer a : customers) {
			if(!customer_name_exist(a.get_customer_name())) {
				get_customers().add(a);
				for(BankAccount ba : a.get_customer_accts()) {
					add_account(ba);
				}
			}
		}
	}
	
	public void create_acct(String acct_type, boolean checking) {
		if(checking) {
			accounts.add(new CheckingAccount(acct_type));
		} else {
			accounts.add(new SavingsAccount(acct_type));
		}
	}
	
	public void remove_acct(int acct_num) {
		if(account_exist(acct_num)) {
			accounts.remove(get_acct(acct_num));
		}
	}
	
	public void create_customer(String name, Address add, int tax_id) {
		if(!customer_name_exist(name)) {
			if(tax_id < 0) {
				customers.add(new Person(name, add));
			} else {
				customers.add(new Company(name, add, tax_id));
			}
		} else {
			System.out.println("Customer already exist.");
		}
	}
	
	public void remove_customer(int cust_id) {
		if(customer_exist(cust_id)) {
			accounts.remove(get_cust(cust_id));
		}
	}
	
	private boolean account_exist(int acct_num) {
		boolean account_exist = false;
		for(BankAccount c : accounts) {
			if(c.get_acct_id() == acct_num) {
				account_exist = true;
			}
		}
		return account_exist;
	}
	
	public BankAccount get_acct(int acct_num) {
		BankAccount acct = null;
		if(account_exist(acct_num)) {
			for(BankAccount a : accounts) {
				if(a.get_acct_id() == acct_num) {
					acct = a;
				}
			}
		}
		return acct;
	}
	
	private boolean customer_exist(int cust_id) {
		boolean customer_exist = false;
		for(BankCustomer c : customers) {
			if(c.get_customer_id() == cust_id) {
				customer_exist = true;
			}
		}
		return customer_exist;
	}
	
	private boolean customer_name_exist(String name) {
		boolean customer_exist = false;
		for(BankCustomer c : customers) {
			if(c.get_customer_name() == name) {
				customer_exist = true;
			}
		}
		return customer_exist;
	}
	
	public BankCustomer get_cust(int cust_id) {
		BankCustomer cust = null;
		if(customer_exist(cust_id)) {
			for(BankCustomer a : customers) {
				if(a.get_customer_id() == cust_id) {
					cust = a;
				}
			}
		}
		return cust;
	}
	
	public void print_account(int acct_num) {
		BankAccount a = get_acct(acct_num); 
		if(a != null) {
			a.display_account();
		}
	}
	
	public void print_accounts() {
		for(BankAccount a : accounts) {
			a.display_account();
		}
	}
	
	public void print_customer(int cust_id) {
		BankCustomer a = get_cust(cust_id); 
		if(a != null) {
			a.display_customer();
		}
	}
	
	public void print_customers() {
		for(BankCustomer a : customers) {
			a.display_customer();
		}
	}
	
	public void display_bank_info() {
		System.out.println("Bank Name: " + bank_name + "\nBank Manager: " + bank_manager);
		bank_address.print_address();
	}
}
