package model;

public class Order implements IPrintable {
	private int quantity;
	private Service service;
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Service getService() {
		return service;
	}
	public void setService(Service service) {
		this.service = service;
	}
	
	public Order(int quantity, Service service) {
		super();
		this.quantity = quantity;
		this.service = service;
	}
	
	@Override
	public void printData() {
		System.out.printf("| %-30s | %-20s | %-20s | %-20d | %-20d | %-20d | %-22.2f | %-20.2f |\n", service.name, service.type, service.subtype, 
				service.duration, service.basePrice, quantity, 
				service.calculatePrice(), service.calculateTotalPrice(quantity));
	}
	
	
	
}
