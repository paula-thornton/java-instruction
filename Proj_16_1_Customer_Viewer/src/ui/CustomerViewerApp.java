package ui;

import business.Customer;
import db.CustomerDB;
import db.NoSuchCustomerException;
import util.Console;

public class CustomerViewerApp {

	public static void main(String[] args) {

		System.out.println("Customer Viewer");
		
		String choice = "y";
		
		while (choice.equalsIgnoreCase("y")) {
			
			int customerNumber = Console.getInt("\nEnter a customer number: ");
			
			try {
				Customer c = CustomerDB.getCustomer(customerNumber);
				System.out.println();
				System.out.println(c.getNameAndAddress());
				
			} catch (NoSuchCustomerException e) {
				System.out.println(e.getMessage());
			}
	
			choice = Console.getString("\nDisplay another customer? (y/n): ", "y", "n");
		}
		
		System.out.println("\nBye!");
	}

}
