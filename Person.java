package BankDesignExercise;

public class Person extends BankCustomer {

	public Person(String name, Address address) {
		super(name, address);
	}
	
	public void alter_accounts(double amount) {
		for(BankAccount a : get_customer_accts()) {
			a.correction(0);
		}
	}

	@Override
	public void add_account(BankAccount... new_accounts) {
		for(BankAccount a : new_accounts) {
			if(a.get_acct_type().equals(AccountType.PERSONAL)) {
				get_customer_accts().add(a);
				a.set_customer(this);
			}
		}		
	}
}
