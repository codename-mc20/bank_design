package BankDesignExercise;

public class Address {
	private String street;
	private int house_number;
	private String city;
	private String state;
	
	public Address(String street, int house_num, String city, String state) {
		this.street = street;
		house_number = house_num;
		this.city = city;
		this.state = state;
	}
	
	public String get_street() {
		return this.street;
	}
	
	public int get_house_num() {
		return house_number;
	}
	
	public String get_city() {
		return this.city;
	}
	
	public String get_state() {
		return this.state;
	}
	
	public String get_address() {
		return house_number + " " + this.street + ", " + this.city + ", " + this.state;
	}
	
	public void print_address() {
		System.out.println("Address: " + house_number + " " + this.street + ", " + this.city + ", " + this.state + "\n");
	}
}
