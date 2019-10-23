import java.util.Arrays;

public class SortedCustomersApp {

    public static void main(String[] args) {
    	
    	//Could do it like this:
        //  Customer[] customers = new Customer[3];
        //  customers[0] = new Customer("mike@murach.com", "Mike", "Murach");
        //  customers[1] = new Customer("joel@murach.com", "Joel", "Murach");
        //  customers[2] = new Customer("anne@murach.com", "Anne", "Boehm");
            
		Customer c1 = new Customer("ef789@gmail.com", "Eric", "Fisher");
		Customer c2 = new Customer("de456@gmail.com", "Dale", "Evans");
		Customer c3 = new Customer("ab123@gmail.com", "Amy", "Baker");
		Customer c4 = new Customer("gh012@gmail.com", "Gary", "Howard");
		
		Customer[] customers = {c1, c2, c3, c4};
		
    	Arrays.sort(customers);
    	for (Customer c: customers) {
    		System.out.println("Name: " + c.getFirstName() + " " + c.getLastName() +
    				"\tEmail: " + c.getEmail() );
    	}
    	
    }
 }
