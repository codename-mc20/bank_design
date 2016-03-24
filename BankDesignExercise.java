package BankDesignExercise;

public class BankDesignExercise {

	public static void main(String[] args) {
		Bank CreditSuisse = new Bank("Credit Suisse", "Raymond Mulligan", new Address("Madison Avenue", 1, "New York", "NY"));
		Bank WellsFargo = new Bank("Wells Fargo", "Paul Gaffney", new Address("Cedar Avenue", 400, "West Long Branch", "NJ"));
		//------------------------------------------------- Display Bank info
		CreditSuisse.display_bank_info();
		WellsFargo.display_bank_info();

		//------------------------------------------------- Create accounts
		BankAccount acct1 = new SavingsAccount("Personal");
		BankAccount acct2 = new SavingsAccount("Business");
		BankAccount acct3 = new SavingsAccount("business");
		BankAccount acct4 = new SavingsAccount("personal");
		BankAccount acct5 = new SavingsAccount("");
		BankAccount acct6 = new SavingsAccount("perosn");
		BankAccount acct7 = new SavingsAccount("businesS");
		BankAccount acct8 = new SavingsAccount("BUSINESS");
		BankAccount acct9 = new SavingsAccount("bUSiness");
		BankAccount acct10 = new SavingsAccount("businessPersonal");
		
		acct1.display_account(); acct2.display_account();
		acct3.display_account(); acct4.display_account();
		acct5.display_account(); acct6.display_account();
		acct7.display_account(); acct8.display_account();
		acct9.display_account(); acct10.display_account();
		
		//------------------------------------------------- Create customers
		BankCustomer michael = new Person("Michael Bennett", new Address("Ocean Avenue", 4521, "Queens", "NY"));
		BankCustomer shop_rite = new Company("ShopRite", new Address("Washington Road", 3250, "Old Bridge", "NJ"), 1467232);
		BankCustomer beatrice = new Person("Beatrice Jones", new Address("Swider Drive", 8, "Parlin", "NJ"));
		
		michael.display_customer(); shop_rite.display_customer(); beatrice.display_customer();
		
		//------------------------------------------------- Add accounts to customers
		michael.add_account(acct1, acct3, acct4, acct8);
		shop_rite.add_account(acct6, acct7, acct9);
		
		michael.print_accounts(); //Only Personal accounts added to a Person
		shop_rite.print_accounts(); //Only Business accounts added to a Company
		
		System.out.println(acct1.get_customer().get_customer_name()); //Customers added to account
		System.out.println(acct7.get_customer().get_customer_name() + "\n");
		
		acct1.display_account();
		acct1.deposit(135.45);
		acct1.display_account();
		acct1.deposit(-135.45); //Error: Cannot deposit a negative amount
		acct1.display_account();
		acct1.withdraw(50);
		acct1.display_account();
		acct1.withdraw(-1000); //Error: Cannot withdraw a negative amount
		acct1.display_account();
		acct1.withdraw(200); //Error: Insufficient funds
		acct1.display_account();

	}

}
