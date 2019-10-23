import java.util.Scanner;

public class CommonDenominatorApp {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
	        
		System.out.println("Welcome to the Common Divisor Finder");
	    System.out.println();  // print a blank line
  	    
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			System.out.print("Enter larger number:   ");
			int y = sc.nextInt();
			
			System.out.print("Enter smaller number:  ");
			int x = sc.nextInt();

			while (x != 0 ) {
						
				while (y >= x) {
					y = y - x;  // same as:  y -= x;
					System.out.println("y = " + y);
					System.out.println("x = " + x);	
				}
				int temp = x;
				x = y;
				y = temp;
				System.out.println("y = " + y);
				System.out.println("x = " + x);	
				
			}
			
			System.out.println("Greatest Common Divsor is: " + y);
				
            System.out.print("\nContinue? (y/n): ");
            choice = sc.next();
            
		}
		System.out.println("Bye");
		sc.close();
	
	}	

}


