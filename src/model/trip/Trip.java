package model.trip;

import model.Service;

public abstract class Trip extends Service {

	public Trip(String name, int basePrice, int duration) {
		super(name, basePrice, duration);
		this.type = "Trip";
		// TODO Auto-generated constructor stub
	}

}
