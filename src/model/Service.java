package model;

public abstract class Service implements IPrintable {

	protected String name, type, subtype;
	protected int basePrice;
	protected int duration;
	
	protected abstract double calculatePrice();
	protected abstract double calculateTotalPrice(int quantity);
	public abstract void printDetail();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(int basePrice) {
		this.basePrice = basePrice;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Service(String name, int basePrice, int duration) {
		super();
		this.name = name;
		this.basePrice = basePrice;
		this.duration = duration;
	}
	
	@Override
	public void printData() {
		// TODO Auto-generated method stub
		System.out.printf("| %-30s | %-20s | %-20s | %-20d | %-20d | %-20.2f |\n", name, type, subtype, duration, basePrice, calculatePrice());
	}

}
