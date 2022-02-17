package model.user;

import model.IPrintable;

public abstract class User implements IPrintable {
	protected String name;
	protected String password;
	protected String email;
	protected String role;
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public User(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public abstract void printDetail();
	
	@Override
	public void printData() {
		// TODO Auto-generated method stub
		System.out.printf("| %-20s | %-30s | %-20s |\n", name, email, role);
	}
	
}
