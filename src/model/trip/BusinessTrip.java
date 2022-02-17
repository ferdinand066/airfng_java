package model.trip;

public class BusinessTrip extends Trip {

	private int minimumPerson;
	private double discount;

	@Override
	protected double calculatePrice() {
		return basePrice * duration * (1 - discount) * 1.05;
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
		System.out.println(" Minimum Person : " + minimumPerson);
		System.out.println(" Discount       : " + (discount * 100) + "%");
		System.out.println(" Tax            : 5%");
		System.out.println("");
		System.out.println(" Total Price    : " + calculatePrice());
	}
	
	public BusinessTrip(String name, int basePrice, int duration, int minimumPerson) {
		super(name, basePrice, duration);
		this.minimumPerson = minimumPerson;
		this.subtype = "BusinessTrip";
		this.discount = (minimumPerson < 3) ? 0 : (Math.floor(Math.random() * 15) + 1) * 0.01;
		
	}

	public int getMinimumPerson() {
		return minimumPerson;
	}

	public void setMinimumPerson(int minimumPerson) {
		this.minimumPerson = minimumPerson;
	}
		

}
