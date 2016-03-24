package BankDesignExercise;

import java.time.LocalDate;

public class Check {
	private int check_number;
	private double amount;
	private String pay_to;
	private LocalDate date;
	
	public Check(int check_number, double amt, String pay_to) {
		this.check_number = check_number;
		amount = amt;
		this.pay_to = pay_to;
		date = LocalDate.now();
	}
	
	public int get_check_number() {
		return this.check_number;
	}
	
	public double get_amount() {
		return this.amount;
	}
	
	public String get_pay_to() {
		return this.pay_to;
	}
	
	public LocalDate get_date() {
		return this.date;
	}
	
	public void print_check() {
		System.out.println("Check No.: " + check_number + "\nDate: " + date + 
				"\nPay To: " + pay_to + "\nAmount: $" + amount + "\n");
	}
}
