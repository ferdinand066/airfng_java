package model.user;

import java.util.Vector;

import model.Order;

public class Customer extends User {

	private Vector<Order> orderList;
	

	public Vector<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(Vector<Order> orderList) {
		this.orderList = orderList;
	}

	public Customer(String name, String email, String password, Vector<Order> orderList) {
		super(name, email, password);
		this.orderList = orderList;
		this.role = "Customer";
	}

	@Override
	public void printDetail() {
		System.out.println(" Email      : " + email);
		System.out.println(" Name       : " + name);
		System.out.print(" Password   : ");
		for (int i=0; i<password.length(); i++) {
			System.out.print("*");
		}
		System.out.println();
		System.out.print(" Order List : ");
		if (orderList.isEmpty()) {
			System.out.println("-");
			return;
		}
		System.out.println();
		System.out.print(" ");
		for(int i=0; i<203; i++) System.out.print("=");
		System.out.println();
		System.out.printf(" | %-3s | %-30s | %-20s | %-20s | %-20s | %-20s | %-20s | %-22s | %-20s |\n", "No", "Name", "Type", "Sub Type", "Duration (day(s))", "Base Price ($)", "Quantity", 
				"Price per Quantity ($)", "Total Price ($)");

		System.out.print(" ");
		for(int i=0; i<203; i++) System.out.print("=");
		System.out.println();
		
		int idx = 1;
		for (Order order : orderList) {
			System.out.printf(" | %03d ", idx++);
			order.printData();
			
		}

		System.out.print(" ");
		for(int i=0; i<203; i++) System.out.print("=");
		System.out.println();
	}
	
	

}
