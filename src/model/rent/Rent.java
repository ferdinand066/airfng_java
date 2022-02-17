package model.rent;

import java.util.Vector;

import model.Detail;
import model.Service;

public abstract class Rent extends Service {

	protected Vector<Detail> facilityList;
	protected String location;
	
	public Vector<Detail> getFacilityList() {
		return facilityList;
	}
	public void setFacilityList(Vector<Detail> facilityList) {
		this.facilityList = facilityList;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	public Rent(String name, int basePrice, int duration, Vector<Detail> facilityList, String location) {
		super(name, basePrice, duration);
		this.facilityList = facilityList;
		this.location = location;
		this.type = "Rent";
	}	
	

}
