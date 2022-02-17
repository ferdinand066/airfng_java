package model;

public class Detail implements IPrintable {
	private String name;
	private int price;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Detail(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
	@Override
	public void printData() {
		System.out.println("Name      : " + name);
		System.out.println("      Price     : $" + price);
	}
	
	
}
