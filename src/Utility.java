import java.io.FileWriter;

import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Service;
import model.trip.Trip;
import model.user.User;

public class Utility {

	private Scanner scan = new Scanner(System.in);
	
	public static Utility instance;
	
	public static synchronized Utility getInstance() {
		if (instance == null) {
			instance = new Utility();
		}
		return instance;
	}
	
	public int scanInt() {
		int num;
		try {
			num = scan.nextInt();
		} catch (Exception e) {
			num = -1;
		}
		scan.nextLine();
		return num;
	}
	
	public double scanDouble() {
		double num;
		try {
			num = scan.nextDouble();
		} catch (Exception e) {
			num = -1;
		}
		scan.nextLine();
		return num;
	}

	public Utility() {
		super();
	}
	
	public int inputInt(String s) {
		System.out.print(s);
		return scanInt();
	}
	
	public double inputDouble(String s) {
		System.out.print(s);
		return scanDouble();
	}
	
	public String inputString(String s) {
		System.out.print(s);
		return scan.nextLine();
	}
	
	public void cls() {
		for (int i=0; i<30; i++) System.out.println();
	}
	
	public void saveData(List<Service> serviceList, List<User> userList) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		try (FileWriter writer = new FileWriter("Service.json")) {
            gson.toJson(serviceList, writer);
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		try (FileWriter writer = new FileWriter("User.json")) {
            gson.toJson(userList, writer);
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	public void printBorder(int idx) {
		System.out.print(" ");
		for (int i = 0; i<idx; i++) System.out.print("=");
		System.out.println();
		
	}
	
	public void printAllService(Vector<Service> serviceList) {
		int idx = 1;
		printBorder(155);
		System.out.printf(" | %-3s | %-30s | %-20s | %-20s | %-20s | %-20s | %-20s |\n", "No", "Name", "Type", "Sub Type", "Duration (day(s))", "Base Price ($)", "Total Price ($)");
		printBorder(155);
		for (Service service : serviceList) {
			System.out.printf(" | %03d ", idx++);
			service.printData();
		}
		printBorder(155);
	}
	
	public void printTitle() {
		System.out.println("      ,---,                            ,---,.                ,---,.       ");
		System.out.println("     '  .' \\        ,--,             ,'  .' |              ,'  .'  \\ ");
		System.out.println("    /  ;    '.    ,--.'|    __  ,-.,---.'   |      ,---, ,---.' .' | ");
		System.out.println("   :  :       \\   |  |,   ,' ,'/ /||   |   .'  ,-+-. /  ||   |  |: | ");
		System.out.println("   :  |   /\\   \\  `--'_   '  | |' |:   :  :   ,--.'|'   |:   :  :  / ");
		System.out.println("   |  :  ' ;.   : ,' ,'|  |  |   ,':   |  |-,|   |  ,\"' |:   |    ;  ");
		System.out.println("   |  |  ;/  \\   \\'  | |  '  :  /  |   :  ;/||   | /  | ||   :     \\ ");
		System.out.println("   '  :  | \\  \\ ,'|  | :  |  | '   |   |   .'|   | |  | ||   |   . | ");
		System.out.println("   |  |  '  '--'  '  : |__;  : |   '   :  '  |   | |  |/ '   :  '; | ");
		System.out.println("   |  :  :        |  | '.'|  , ;   |   |  |  |   | |--'  |   |  | ;  ");
		System.out.println("   |  | ,'        ;  :    ;---'    |   :  \\  |   |/      |   :   /   ");
		System.out.println("   `--''          |  ,   /         |   | ,'  '---'       |   | ,'    ");
		System.out.println("                   ---`-'          `----'                `----'      ");      
		System.out.println(" =================================================================================");
	}
	
	

}
