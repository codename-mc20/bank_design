package BankDesignExercise;

import java.text.NumberFormat;

public class SavingsAccount extends BankAccount {
	private double interest_rate;
	
	public SavingsAccount(String acct_type){
		super(acct_type);
		interest_rate = 0.00;
	}

	public double get_interest_rate() {
		return interest_rate;
	}

	protected void set_interest_rate(double interest_rate) {
		this.interest_rate = interest_rate;
	}
	
	public void display_interest_rate() {
		System.out.println("Current interest rate is: " + get_interest_rate() + "%.\n");
	}
	
	@Override
	public void withdraw(double amount) {
		if(amount >= 0) {
			if(get_acct_bal() < amount) {
				System.out.println("Insufficient Funds.\n");
			} else {
				set_acct_bal(get_acct_bal() - amount);
				System.out.println("Withdrawal of " + NumberFormat.getCurrencyInstance().format(amount) + " completed.\n");
			}
		} else {
			System.out.println("Invalid request: Cannot withdraw a negative amount.\n");
		}
	}
}
