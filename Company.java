package BankDesignExercise;

public class Company extends BankCustomer {
	private int tax_id;
	
	public Company(String name, Address address, int tax_id) {
		super(name, address);
		this.tax_id = tax_id;
	}

	public int get_tax_id() {
		return tax_id;
	}
	
	public void alter_accounts(double amount) {
		for(BankAccount a : get_customer_accts()) {
			a.deposit(amount);
		}
	}

	@Override
	public void add_account(BankAccount... new_accounts) {
		for(BankAccount a : new_accounts) {
			if(a.get_acct_type().equals(AccountType.BUSINESS)) {
				get_customer_accts().add(a);
				a.set_customer(this);
			}
		}		
	}
}
