import java.util.Vector;

import model.Detail;
import model.Order;
import model.Service;
import model.rent.House;
import model.trip.BusinessTrip;
import model.trip.PersonalTrip;
import model.trip.VacationTrip;
import model.user.*;

public class Main {
	
	private Vector<User> userList = new Vector<>();
	private Vector<Service> serviceList = new Vector<>();
	private Utility utility = Utility.getInstance();

	
	public Main() {
		initData();
		
		int menu;
		do {
			utility.cls();
			utility.printTitle();
			System.out.println("  1. Login"); 
			System.out.println("  2. Register"); 
			System.out.println("  3. Exit"); 
			menu = utility.inputInt(" >> ");
			utility.cls();
			switch (menu) {
			case 1:
				login();
				break;
			case 2:
				register();
				break;
			case 3:
				saveData();
				System.out.println(" Thank you for using AirFnG");
				utility.inputString(" Press enter to continue!!");
				logo();
				break;
			default:
				break;
			}
			utility.cls();
		} while (menu != 3);
	}
	
	private void logo() {
		String[] test = new String[]{
				"                               ╓▄╗µ              -",
				"                           ,▄▓▓██╬╬╬▓╗,      ▄@╙",
				"                       ,▄▓▓▓▓▓▓█╬░╠╬╢╣╣╣▓▄▄█▀ⁿ",
				"                    ╓@▓▓▓▓▓▓╬╠╠╣╣▒╠╠╠╠███▀░╢▒╤",
				"                ┌@▓╣╣╣╣╣╬╠╠╠╣╣╬╣╣▒▄███▀░╠╠╠╠╠╠╠╠δ-",
				"                ╞▓▓▓╬╠╠╠╠╠╣╣▓▓╠████▀░φ▒╠╠╠╠╠╠╝╚░░ε",
				"                ╞▓▓▓▌φ░╠╣▓╠█████▀░╠║╣╣╣╣╣╬╙└''░░░ε",
				"                ╞▓▓▓▌╠╠╠▓╣███▀░╠φ║▒Q--╓█▓╠⌐'''░░░ε",
				"                ╞▓▓▓▒╠╠╠▓▓█▌░░▒╣╬╬╠╠▄██▓▌╠⌐'''░░░ε",
				"                ╞▓▓╠▒╠╠╠▓██░╙└╣╣╬╠██████▌╠∩.''░░░ε",
				"                ╞╣▒╠╠╠╠╠▓█░;;;;╠████▀░╙╙▀╠░-~.░░░[",
				"                ╞╬╠╠╠╠╠╠╠╝╣╬╠████▀░░░╔φ╠╚╙'ⁿ░░░░░[",
				"                ╞╠╠╚╚╚╠╠╠╠φ███▀░░▒φ╠╩╙└.''''''^ⁿ░[",
				"                 '╚░░░░░▄██▀░▒φ╬╠╙└^''''''",
				"                     ]▄█▀≥╙└╙╙╣╠╠⌐'''",
				"                   ,█▀╙` '''''└╙'",
				"                 ▄▀╙          '''",
		};
		System.out.println("\n\n");
			
		for(int i = 0; i < test.length; i++) {
			System.out.println(test[i]);
			try {
				Thread.sleep(75);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		   
		System.out.println();
	    char[] str = new char[100];
	    char[] str2 = new char[100];
		String s = new String("    Through hard work and dedication we hold our future in our hands");
		String b = new String("- Bluejackets 20-1");
		str = s.toCharArray();
		str2 = b.toCharArray();
		for (char c : str) {
			try {
				Thread.sleep(60);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.print(c);
		}
		System.out.print("\n\t\t\t");
		for(char c : str2) {
			try {
				Thread.sleep(60);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.print(c);
		}
	}
	
	private void saveData() {
		utility.saveData(serviceList, userList);
	}

	private void login() {
		String email, password;
		User user;
		do {
			do {
				email = utility.inputString(" Input your email    : ");
				email = email.trim();
			} while (!checkEmail(email));
			
			do {
				password = utility.inputString(" Input your password : ");
				password = password.trim();
			} while (password.length() < 5);
			
			user = checkUser(email, password);
			if (user != null) {
				break;
			} else {
				System.out.println(" Invalid Authentication");
				utility.inputString(" Press enter to continue!!");
				utility.cls();
			}
		} while(true);
		
		if (user instanceof Admin) {
			new AdminMenu(user, serviceList, userList);
		} else {
			new CustomerMenu(user, serviceList);
		}
		
		
	}

	private User checkUser(String email, String password) {
		User temp = null;
		for (User user : userList) {
			if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
				temp = user;
				break;
			}
		}
		return temp;
	}

	private void register() {
		String name, email, password;
		do {
			name = utility.inputString(" Input your name [min. 5 characters]     : ");
			name = name.trim();
		} while (name.length() < 5);
		
		do {
			email = utility.inputString(" Input your email [must be unique]       : ");
			email = email.trim();
		} while (!checkUniqueEmail(email));
		
		do {
			password = utility.inputString(" Input your password [min. 5 characters] : ");
			password = password.trim();
		} while (password.length() < 5);
		
		userList.add(new Customer(name, email, password, new Vector<Order>()));
	}
	
	
	private boolean checkEmail(String email) {
		if (email.length() == 0) return false;
		if (!email.contains("@") || email.indexOf("@") != email.lastIndexOf("@")) return false;
		return true;
	}

	private boolean checkUniqueEmail(String email) {
		if (!checkEmail(email)) return false;
		
		for (User user : userList) {
			if (user.getEmail().equals(email)) {
				return false;
			}
		}
		return true;
	}

	private void initData() {
		Vector<Detail> locationList = new Vector<Detail>();
		locationList.add(new Detail("Ranch Bandung", 5));
		locationList.add(new Detail("Transtudio Bandung", 20));
		serviceList.add(new VacationTrip("Lembang Banding Trip", 30, 3, locationList));

		serviceList.add(new BusinessTrip("Semarang Trip", 40, 5, 5));
		serviceList.add(new PersonalTrip("Bekasi Trip", 25, 2));
		
		
		Vector<Detail> facilityList = new Vector<Detail>();
		facilityList.add(new Detail("Toilet", 15));
		
		facilityList.add(new Detail("Bedroom", 25));
		serviceList.add(new House("Yogyakarta House Rent", 35, 10, facilityList, "Jl. Sudirman no 1"));
		
		
		userList.add(new Admin("Ferdinand", "admin@admin.com", "admin"));
		userList.add(new Customer("Stephanus", "stephanus@admin.com", "admin", new Vector<Order>()));
		userList.add(new Customer("Daniel", "daniel@admin.com", "admin", new Vector<Order>()));
	}

	public static void main(String[] args) {
		new Main();
	}

}
