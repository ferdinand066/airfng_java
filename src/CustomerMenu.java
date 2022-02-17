import java.util.Vector;

import model.Order;
import model.Service;
import model.user.Customer;
import model.user.User;

public class CustomerMenu {

	private Customer user;
	private Vector<Service> serviceList;
	private Utility utility = Utility.getInstance();
	
	public CustomerMenu(User user, Vector<Service> serviceList) {
		this.user = (Customer)user;
		this.serviceList = serviceList;
		mainMenu();
	}

	private void mainMenu() {
		int menu;
		do {
			utility.cls();
			utility.printTitle();
			System.out.println("  1. Order Service"); 
			System.out.println("  2. Cancel Service"); ; 
			System.out.println("  3. Exit");
			menu = utility.inputInt(" >> ");
			utility.cls();
			switch (menu) {
			case 1:
				orderService();
				break;
			case 2:
				cancelService();
				break;
			default:
				break;
			}
			utility.cls();
		} while (menu != 3);
	}

	private void cancelService() {
		if (user.getOrderList().size() == 0) {
			utility.inputString(" You have no order yet!");
		}
		else {
			printAllOrder();
			int menu;
			do {
				menu = utility.inputInt(" Choose service [1 - " + user.getOrderList().size() + "][0 to exit] : ");
			} while (menu < 0 || menu > user.getOrderList().size());
			
			if (menu > 0) {
				((Customer)user).getOrderList().remove(menu - 1);
			}
			System.out.println();
		}
		utility.inputString(" Press enter to continue!!");
	}

	private void orderService() {
		utility.printAllService(serviceList);
		int menu;
		do {
			menu = utility.inputInt(" Choose service [1 - " + serviceList.size() + "][0 to exit] : ");
		} while (menu < 0 || menu > serviceList.size());
		
		if (menu > 0) {
			int quantity;
			do {
				quantity = utility.inputInt(" Input number of persons [min. 1]  : ");
			} while (quantity < 1);
			
			user.getOrderList().add(new Order(quantity, serviceList.get(menu - 1)));
		}
		System.out.println();
		utility.inputString(" Press enter to continue!!");
		utility.cls();
	}

	public void printAllOrder() {
		int idx = 1;
		utility.printBorder(203);
		System.out.printf(" | %-3s | %-30s | %-20s | %-20s | %-20s | %-20s | %-20s | %-22s | %-20s |\n", "No", "Name", "Type", "Sub Type", "Duration (day(s))", "Base Price ($)", "Quantity", 
				"Price per Quantity ($)", "Total Price ($)");
		utility.printBorder(203);
		for (Order order : user.getOrderList()) {
			System.out.printf(" | %03d ", idx++);
			order.printData();
		}
		utility.printBorder(203);
	}

	
}
