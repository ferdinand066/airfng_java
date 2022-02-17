package model.rent;

import java.util.Vector;

import model.Detail;

public class House extends Rent {

	public House(String name, int basePrice, int duration, Vector<Detail> facilityList, String location) {
		super(name, basePrice, duration, facilityList, location);
		this.subtype = "House";
	}


	@Override
	protected double calculatePrice() {
		// TODO Auto-generated method stub
		double temp = 0;
		for (Detail facility : facilityList) {
			temp += facility.getPrice();
		}
		return (duration * basePrice) + temp;
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
		System.out.println(" Location       : " + location);
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
		System.out.println(" Total Price    : " + calculatePrice());
	}

}
