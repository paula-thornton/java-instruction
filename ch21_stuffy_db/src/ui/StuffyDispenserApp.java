package ui;

import java.util.List;


import business.Stuffy;
import db.StuffyDB;
import util.Console;

public class StuffyDispenserApp {
	private static StuffyDB sdb = new StuffyDB();

	public static void main(String[] args) {
		System.out.println("Welcome to the Stuffy Dispenser App");

		int command = 0;
		int id = 0;

		while (command != 6) {
			command = Console.getInt(getMenu(), 0, 7);

			switch (command) {
			case 1:			// DONE
				// list
				List<Stuffy> stuffys = sdb.getAll();
				if (stuffys == null) {
					System.out.println("Error - no stuffies found");
				} else {
					for (Stuffy s: stuffys) {
						System.out.println(s);
					}
				}	
				break;
				
			case 2: 		// DONE
				// get
				id = Console.getInt("ID: ");
				Stuffy s = getStuffy(id);
				break;
				
			case 3:
				// add - prompt user for stuffy values
				String type = Console.getString( "Type:  ");
				String color = Console.getString("Color: ");
				String size = Console.getString( "Size:  ");
				int limbs = Console.getInt(      "Limbs: ");
				s = new Stuffy(type, color, size, limbs);
				int rowCount = sdb.add(s);
				System.out.println(rowCount + " row(s) added");
				break;
				
			case 4:			// DONE
				// edit - prompt user for new stuffy values
				id = Console.getInt("ID: ");
				s = getStuffy(id);
				if (s != null) {
					type = Console.getString( "New type:  ");
					color = Console.getString("New color: ");
					size = Console.getString( "New size:  ");
					limbs = Console.getInt(   "New limbs: ");
					s = new Stuffy(id, type, color, size, limbs);
					rowCount = sdb.update(s);
					System.out.println(rowCount + " row(s) updated");
				}
				break;
				
			case 5: 		// DONE
				// delete
				id = Console.getInt("ID: ");
				s = getStuffy(id);
				rowCount = sdb.delete(s);
				System.out.println(rowCount + " row(s) deleted");
				break;
				
			case 6: 		// DONE
				// exit
				break;
				
			default: 		// DONE
				System.out.println("Invalid command: ");
				break;
			}

		}
		System.out.println("Bye!");

	}

	private static String getMenu() {
		String menu = "\nCOMMAND:\n" + "1 = List\n" + "2 = Get\n" + "3 = Add\n" + "4 = Edit\n" + "5 = Delete\n"
				+ "6 = Exit\n" + "\nCommand: ";
		return menu;
	}

	private static Stuffy getStuffy(int id) {

		Stuffy s = sdb.get(id);
		if (s != null) {
			System.out.println("Stuffy: ");
			System.out.println(s);
		} else {
			System.out.println("No stuffy exists for id: " + id);
		}
		return s;
	}

}
