package ui;

import java.text.NumberFormat;
import java.util.List;

import business.Item;
import business.SalesHistory;
import business.OrderHistory;
import db.ItemDB;
import db.OrderHistoryDB;
import db.SalesHistoryDB;
import util.Console;

public class CaoItemApp {
	private static ItemDB idb = new ItemDB();
	private static OrderHistoryDB ohdb = new OrderHistoryDB();
	private static SalesHistoryDB shdb = new SalesHistoryDB();

	public static void main(String[] args) {

		System.out.println("Welcome to the CAO Item Lookup");
		boolean keepGoing = true;

		while (keepGoing == true) {

			String upc = Console.getString("\nEnter UPC or 'Exit' to exit. ");
			if (upc.equalsIgnoreCase("exit")) {
				keepGoing = false;
				break;
			}
			Item item = idb.getItem(upc);
			if (item == null) {
				System.out.println("UPC not found. ");
				continue;
			} else {
				displayItem(item);
				keepGoing = itemProcessing(item);
			}
		}
		System.out.println("\n\nBye!");
	}

	public static boolean itemProcessing(Item item) {
		boolean keepGoing = true;
		String menu = getMenu();
		int choice = 0;
		while (choice != 5) {
			System.out.println(menu);
			choice = Console.getInt("Selection: ", 0, 6);

			switch (choice) {
			case 1:
				// update item
				boolean isValid = false;
				String status = " ";
				while (! isValid) {
					System.out.println("Current status is " + item.getStatus());
					status = Console.getString("Enter new Status: A=Active, I=Inactive, D=Discontinued ");
					if (status.equalsIgnoreCase("A")) {
						status = "Active";
						isValid = true;
					} else if (status.equalsIgnoreCase("I")) {
							status = "Inactive";
							isValid = true;
					} else if (status.equalsIgnoreCase("D")) {
							status = "Discontinued";
							isValid = true;
					}	
				}	
				int boh = Console.getInt("Current BOH = " + item.getBoh() + ". Enter new BOH: ");
				System.out.println("status = " + status);
				item.setStatus(status);
				System.out.println("boh = " + boh);
				item.setBoh(boh);
				int rowCount = idb.update(item);
				displayItem(item);
				break;
			case 2:
				// view sales history
				List<SalesHistory> salesHist = shdb.getForItem(item.getUpc());
				if (salesHist == null) {
					System.out.println("Error - no sales history found");
				} else {
					System.out.println("\nSALES HISTORY");
					System.out.println("Date         UPC             Retail        Units");
					for (SalesHistory s : salesHist) {
						System.out.println(s);
					}
				}
				break;
			case 3:
				// view order history
				// view sales history
				List<OrderHistory> orderHist = ohdb.getOrdHistForItem(item.getUpc());
				if (orderHist == null) {
					System.out.println("Error - no order history found");
				} else {
					System.out.println("\nORDER HISTORY");
					System.out.println("Order#  UPC            Delivery   Status Sugg  Actual  Recv  Adj Code");
					for (OrderHistory o : orderHist) {
						System.out.println(o);
					}
				}
				break;
			case 4:
				// enter new item
				choice = 5;
				break;
			case 5:
				// exit
				keepGoing = false;
				break;
			}
		}
		return keepGoing;
	}

	public static void displayItem(Item item) {
		NumberFormat cf = NumberFormat.getCurrencyInstance(); // cf short for number format
		cf.setMinimumFractionDigits(2);
		cf.setMaximumFractionDigits(2);   
		
		System.out.println();
		System.out.println("UPC     " + item.getUpc());
		System.out.println("Desc    " + item.getDescription());
		System.out.println("Status  " + item.getStatus());
		System.out.println("Retail  " + item.getRetailMultiple() + " for " + cf.format(item.getRetail()));
		System.out.println("BOH     " + item.getBoh() + "\t\t" + "Pack   " + item.getPack());
		System.out.println("Min     " + item.getMin() + "\t\t" + "Alloc  " + item.getAlloc());
		System.out.println();
	}

	private static String getMenu() {
		String menu = "\nCOMMAND:\n" + "1 = Update Item\n" + "2 = View Sales History\n" + "3 = View Order History\n"
				+ "4 = Enter New Item\n" + "5 = Exit\n";
		return menu;
	}

}
