package model.rent;

import java.util.Vector;

import model.Detail;

public class Villa extends Rent {
	
	private int maximumPerson;
	private int chargePerPerson;

	public int getMaximumPerson() {
		return maximumPerson;
	}

	public void setMaximumPerson(int maximumPerson) {
		this.maximumPerson = maximumPerson;
	}

	public int getChargePerPerson() {
		return chargePerPerson;
	}

	public void setChargePerPerson(int chargePerPerson) {
		this.chargePerPerson = chargePerPerson;
	}

	public Villa(String name, int basePrice, int duration, Vector<Detail> facilityList, String location,
			int maximumPerson, int chargePerPerson) {
		super(name, basePrice, duration, facilityList, location);
		this.maximumPerson = maximumPerson;
		this.chargePerPerson = chargePerPerson;
		this.subtype = "Villa";
	}


	@Override
	protected double calculatePrice() {
		// TODO Auto-generated method stub
		double temp = 0;
		for (Detail facility : facilityList) {
			temp += facility.getPrice();
		}
		return ((duration * basePrice) + temp) * 1.1;
	}
	
	@Override
	protected double calculateTotalPrice(int quantity) {
		double temp = (quantity > maximumPerson) ? (quantity - maximumPerson) * chargePerPerson : 0;
		return calculatePrice() * quantity + temp;
	}
	


	@Override
	public void printDetail() {
		System.out.println(" Name           : " + name);
		System.out.println(" Type           : " + type);
		System.out.println(" Subtype        : " + subtype);
		System.out.println(" Duration       : " + duration + " day(s)");
		System.out.println(" Base Price     : $" + basePrice + "/day");
		System.out.println(" Location       : " + location);
		System.out.println(" Maximum Person in One Transaction : " + maximumPerson);
		System.out.println(" Charge Price per Person           : $" + chargePerPerson);
		System.out.print(" Facility List    : ");
		if (facilityList.isEmpty()) {
			System.out.println("-");
			return;
		}
		System.out.println();
		int i = 1;
		for (Detail facility : facilityList) {
			System.out.printf(" %4s ", Integer.toString(i) + ".");
			facility.printData();
			i++;
		}
		System.out.println(" Service Charge : 10%");
		System.out.println(" Total Price    : " + calculatePrice());
	}
	
	

}
