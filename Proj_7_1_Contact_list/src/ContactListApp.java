
public class ContactListApp {

	public static void main(String[] args) {

		System.out.println("Welcome to the Contact List application");

		String choice = "y";

		// equalsIgnoreCase is a non-static class b/c you have to pass in an instance variable (choice)
		while (choice.equalsIgnoreCase("y")) {  
			Contact contact = new Contact(); 

			// getString = static.  Don't need to pass in an instance
			// static methods are often utility-type methods
			contact.setFirstName(Console.getString("\nEnter first name: "));
			contact.setLastName(Console.getString("Enter last name:  "));
			contact.setEmail(Console.getString("Enter email:      "));
			contact.setPhone(Console.getString("Enter phone:      "));
			
		//	System.out.println("\n-----------------------------------------------------------------------");
		//	System.out.println("---- Current Contact --------------------------------------------------");
		//	System.out.println("-----------------------------------------------------------------------");

		//	System.out.println("Name:           " + contact.getFirstName() + " " + contact.getLastName());
		//	System.out.println("Email Address:  " + contact.getEmail());
		//	System.out.println("Phone Number:   " + contact.getPhone());
		//	System.out.println("-----------------------------------------------------------------------\n");

			System.out.println(contact.displayContact());

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
