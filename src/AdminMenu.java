

import java.util.Vector;

import model.Detail;
import model.Order;
import model.Service;
import model.rent.House;
import model.rent.Villa;
import model.trip.BusinessTrip;
import model.trip.PersonalTrip;
import model.trip.VacationTrip;
import model.user.Admin;
import model.user.Customer;
import model.user.User;

public class AdminMenu {

	private User user;
	private Vector<Service> serviceList;
	private Vector<User> userList;
	private Utility utility = Utility.getInstance();
	
	public AdminMenu(User user, Vector<Service> serviceList, Vector<User> userList) {
		// TODO Auto-generated constructor stub
		this.user = user;
		this.serviceList = serviceList;
		this.userList = userList;
		mainMenu();
	}
	
	private void mainMenu(){
		int menu;
		do {
			utility.cls();
			utility.printTitle();
			System.out.println("  1. View User"); 
			System.out.println("  2. Update User"); 
			System.out.println("  3. View Service"); 
			System.out.println("  4. Insert Service"); 
			System.out.println("  5. Delete Service"); 
			System.out.println("  6. Exit");
			menu = utility.inputInt(" >> ");
			utility.cls();
			switch (menu) {
			case 1:
				viewUser();
				break;
			case 2:
				updateUser();
				break;
			case 3:
				viewService();
				break;
			case 4:
				insertService();
				break;
			case 5:
				deleteService();
				break;
			default:
				break;
			}
			utility.cls();
		} while (menu != 6);
	}

	private void viewService() {
		// TODO Auto-generated method stub
		utility.printAllService(serviceList);
		int menu;
		do {
			menu = utility.inputInt(" View service detail [1 - " + serviceList.size() + "][0 to exit] : ");
		} while (menu < 0 || menu > serviceList.size());
		
		if (menu > 0) {
			utility.cls();
			serviceList.get(menu - 1).printDetail();
		}
		System.out.println();
		utility.inputString(" Press enter to continue!!");
	}

	private void deleteService() {
		utility.printAllService(serviceList);
		int menu;
		do {
			menu = utility.inputInt(" Delete service [1 - " + serviceList.size() + "][0 to exit] : ");
		} while (menu < 0 || menu > serviceList.size());
		
		if (menu > 0) {
			utility.cls();
			serviceList.remove(menu - 1);
		}
		System.out.println();
		utility.inputString(" Press enter to continue!!");
	}

	private void insertService() {
		String name, type, subtype;
		int basePrice, duration;
		utility.cls();
		do {
			type = utility.inputString(" Insert type of service [Rent | Trip][Case Sensitive] : ");
		} while(!type.equals("Rent") && !type.equals("Trip"));
		
		do {
			name = utility.inputString (" Input service name [min. 5 character]                : ");
		} while(name.trim().length() < 5);
		
		do {
			basePrice = utility.inputInt(" Input service base price [min. 10]                   : ");
		} while(basePrice < 10);
		
		do {
			duration = utility.inputInt(" Input " + type.toLowerCase() + " duration [min. 1]                         : ");
		} while (duration < 1);
		
		if (type.equals("Rent")) {
			Vector<Detail> facilityList = new Vector<>();
			String location;
			
			do {
				subtype  = utility.inputString(" Input rent subtype [House | Villa][Case Sensitive]   : ");
			} while (!subtype.equals("House") && !subtype.equals("Villa"));
			
			do {
				location = utility.inputString(" Input rent location [min. 2 words]                   : ");
			} while (!location.trim().contains(" "));
			
			System.out.println(" Input list of facility [Type 0 to cancel]");
			int i = 1;
			do {
				String detailName;
				int detailPrice;
				
				do {
					detailName = utility.inputString("  Input facility " + i + " name [min. 5 character]            : ");
					if (detailName.trim().equals("0")) break;
				} while (detailName.trim().length() < 5);
				
				if (detailName.trim().equals("0")) break;
				
				do {
					detailPrice = utility.inputInt("  Input facility " + i + " price [min. 5]                     : ");
					if (detailPrice == 0) break;
				} while (detailPrice < 5);
				
				if (detailPrice == 0) break;
				
				facilityList.add(new Detail(detailName, detailPrice));
				i++;
			} while (true);
			
			if (subtype.equals("House")) {
				serviceList.add(new House(name, basePrice, duration, facilityList, location));
			} else {
				int maximumPerson, chargePerPerson;
				
				do {
					maximumPerson = utility.inputInt  (" Input maximum person of one transaction [min. 1]     : ");
				} while (maximumPerson < 1);
				
				do {
					chargePerPerson = utility.inputInt  (" Input charge price per person if the number of people exceeds the limit [min. 10] : ");
				} while (chargePerPerson < 10);
				serviceList.add(new Villa(name, basePrice, duration, facilityList, location, maximumPerson, chargePerPerson));
			}
			
		} else {
			do {
				subtype  = utility.inputString(" Input trip subtype [PersonalTrip | BusinessTrip | VacationTrip][Case Sensitive]      : ");
			} while (!subtype.equals("PersonalTrip") && !subtype.equals("BusinessTrip") && !subtype.equals("VacationTrip"));
			
			if (subtype.equals("PersonalTrip")) {
				serviceList.add(new PersonalTrip(name, basePrice, duration));
			} else if (subtype.equals("BusinessTrip")) {
				int minimumPerson;
				do {
					minimumPerson = utility.inputInt  (" Input minimum person of one transaction [min. 1]              : ");
				} while (minimumPerson < 1);
				serviceList.add(new BusinessTrip(name, basePrice, duration, minimumPerson));
			} else {
				Vector<Detail> locationList = new Vector<>();
				int i = 1;
				do {
					String locationName;
					int locationPrice;
					do {
						locationName = utility.inputString(" Input location " + i + " name [min. 5 character]             : ");
						if (locationName.trim().equals("0")) break;
					} while (locationName.trim().length() < 5);
					
					if (locationName.trim().equals("0")) break;
					
					do {
						locationPrice = utility.inputInt(" Input location " + i + " price [min. 5]                      : ");
						if (locationPrice == 0) break;
					} while (locationPrice < 5);
					
					if (locationPrice == 0) break;
					
					locationList.add(new Detail(locationName, locationPrice));
					i++;
				} while (true);
				
				serviceList.add(new VacationTrip(name, basePrice, duration, locationList));
			}
		}
		System.out.println(" Insert success...");
		utility.inputString(" Press enter to continue!!");
	}

	private void updateUser() {
		printAllUser();
		int menu;
		do {
			menu = utility.inputInt(" Update user detail [1 - " + userList.size() + "][0 to exit] : ");
		} while (menu < 0 || menu > userList.size());
		
		if (menu > 0) {
			User temp = userList.get(menu - 1);
			if (temp.equals(user)) {
				System.out.println();
				utility.inputString(" You cannot update yourself!!");
				return;
			}
			utility.cls();
			
			String name, role;
			do {
				name = utility.inputString(" Input user name [min. 5 characters]                : ");
				name = name.trim();
			} while (name.length() < 5);
			
			do {
				role = utility.inputString(" Input user role [Admin | Customer][Case Sensitive] : ");
			} while (!role.equals("Admin") && !role.equals("Customer"));
			
			
			if (role.equals("Admin")) {
				userList.setElementAt(new Admin(name, temp.getEmail(), temp.getPassword()), menu - 1);
			} else {
				userList.setElementAt(new Customer(name, temp.getEmail(), temp.getPassword(), new Vector<Order>()), menu - 1);
			}
		}
		System.out.println();
		utility.inputString(" Press enter to continue!!");
	}

	private void viewUser() {
		printAllUser();
		int menu;
		do {
			menu = utility.inputInt(" View user detail [1 - " + userList.size() + "][0 to exit] : ");
		} while (menu < 0 || menu > userList.size());
		
		if (menu > 0) {
			utility.cls();
			userList.get(menu - 1).printDetail();
		}
		System.out.println();
		utility.inputString(" Press enter to continue!!");
	}

	private void printAllUser() {
		int idx = 1;
		utility.printBorder(86);
		System.out.printf(" | %-3s | %-20s | %-30s | %-20s |\n", "No", "Name", "Email", "Role");
		utility.printBorder(86);
		for (User user : userList) {
			System.out.printf(" | %03d ", idx++);
			user.printData();
		}
		utility.printBorder(86);
	}
	


}
