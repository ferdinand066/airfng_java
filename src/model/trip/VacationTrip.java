package model.trip;

import java.util.Vector;

import model.Detail;

public class VacationTrip extends Trip {
	
	private Vector<Detail> locationList;


	public VacationTrip(String name, int basePrice, int duration, Vector<Detail> locationList) {
		super(name, basePrice, duration);
		this.locationList = locationList;
		this.subtype = "VacationTrip";
	}
	

	@Override
	protected double calculatePrice() {
		double temp = 0;
		for (Detail location : locationList) {
			temp += location.getPrice();
		}
		
		return (basePrice * duration + temp) * 1.1;
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
		System.out.println(" Tax            : 10%");
		
		System.out.print(" Additional Vacation Location List    : ");
		if (locationList.isEmpty()) {
			System.out.println("-");
			return;
		}
		System.out.println();
		int i = 1;
		for (Detail location : locationList) {
			System.out.printf(" %4s ", Integer.toString(i) + ".");
			location.printData();
			i++;
		}
		System.out.println("");
		System.out.println(" Total Price    : " + calculatePrice());
		
	}

}
