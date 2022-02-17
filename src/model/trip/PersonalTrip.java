package model.trip;

public class PersonalTrip extends Trip {

	public PersonalTrip(String name, int basePrice, int duration) {
		super(name, basePrice, duration);
		this.subtype = "PersonalTrip";
		// TODO Auto-generated constructor stub
	}
	
	

	@Override
	protected double calculatePrice() {
		// TODO Auto-generated method stub
		return basePrice * duration * 1.05;
	}
	
	@Override
	protected double calculateTotalPrice(int quantity) {
		return calculatePrice() * quantity;
	}

	@Override
	public void printDetail() {
		System.out.println(" Name           : " + name);
		System.out.println(" Type           : " + type);
		System.out.println(" Subtype        : " + subtype);
		System.out.println(" Duration       : " + duration + " day(s)");
		System.out.println(" Base Price     : $" + basePrice + "/day");
		System.out.println(" Tax            : 5%");
		System.out.println("");
		System.out.println(" Total Price    : " + calculatePrice());
	}
	
	

}
