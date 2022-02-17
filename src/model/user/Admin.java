package model.user;

public class Admin extends User {


	public Admin(String name, String email, String password) {
		super(name, email, password);
		this.role = "Admin";
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
	}

}
