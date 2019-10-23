
public class PersonManagerApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Person Manager");

		String choice = "y";

		// equalsIgnoreCase is a non-static class b/c you have to pass in an instance variable (choice)
		while (choice.equalsIgnoreCase("y")) { 
			
			String personType = Console.getString("Create customer or employee? (c/e): ", "c", "e");

			String fName = Console.getString("\nFirst name: ");
			String lName = Console.getString("Last name:  ");

			Person person = null;
			
			if (personType.equalsIgnoreCase("C")) {
				String custNumber = Console.getString("Customer number: ");
				Customer c = new Customer(fName, lName, custNumber);
				person = c;
			} else {
				String ssn = Console.getString("SSN: ");
				Employee e = new Employee(fName, lName, ssn);
				person = e;
			}
			
			// display results
			System.out.println("\nYou enterd a new " + person.getClass().getName() );
			System.out.println(person);
			
			boolean isValid = false;
			while (!isValid) {
				choice = Console.getString("Continue? (y/n): ");
				if (choice.equalsIgnoreCase("y") || (choice.equalsIgnoreCase("n"))) {
					isValid = true;
				} else {
					System.out.println("Enter y or n");
				}
			}
			
		}
		System.out.println("Have a nice day!");

	}


}
