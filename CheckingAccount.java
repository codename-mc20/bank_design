package BankDesignExercise;

import java.text.NumberFormat;
import java.util.ArrayList;

public class CheckingAccount extends BankAccount {
	private int check_num;
	private int next_check_num;
	private ArrayList<Check> check_book;
	
	public CheckingAccount(String acct_type) {
		super(acct_type);
		check_num = 0001;
		next_check_num = check_num + 1;
		check_book = new ArrayList<Check>();
	}

	public int get_check_num() {
		return check_num;
	}

	public int get_next_check_num() {
		return next_check_num;
	}

	public ArrayList<Check> get_check_book() {
		return check_book;
	}
	
	public void write_check(double amount, String pay_to) {
		Check new_check = new Check(get_check_num(), amount, pay_to);
		check_book.add(new_check);
		this.check_num++;
		this.next_check_num++;
	}
	
	private boolean does_exist(int check_num) {
		boolean check_exist = false;
		for(Check c : check_book) {
			if(c.get_check_number() == check_num) {
				check_exist = true;
			}
		}
		return check_exist;
	}
	
	public Check get_check(int check_num) {
		Check check = null;
		if(does_exist(check_num)) {
			for(Check c : check_book) {
				if(c.get_check_number() == check_num) {
					check = c;
				}
			}
		}
		return check;
	}
	
	public void print_check(int check_num) {
		Check c = get_check(check_num); 
		if(c != null) {
			c.print_check();
		}
	}
	
	public void print_check_book() {
		for(Check c : check_book) {
			c.print_check();
		}
	}
	
	@Override
	public void withdraw(double amount) {
		if(amount >= 0) {
			set_acct_bal(get_acct_bal() - amount);
			System.out.println("Withdrawal of " + NumberFormat.getCurrencyInstance().format(amount) + "completed.\n");
			
			if(get_acct_bal() < amount)
				System.out.println("Account Overdrawn.\n");
		} else {
			System.out.println("Invalid request: Cannot withdraw a negative amount.\n");
		}

	}
}
