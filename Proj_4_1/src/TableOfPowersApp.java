import java.util.Scanner;

public class TableOfPowersApp {

	public static void main(String[] args) {
        
	    @SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
	        
		System.out.println("Welcome to the Squares and Cubes Table");
	    System.out.println();  // print a blank line

		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			System.out.print("Enter an integer:  ");
			int inputInt = sc.nextInt();
			
			System.out.println("Number  Squared Cubed");
			System.out.println("======  ======= ======");
		
			for (int i=1; i<= inputInt; i++) {
				int iSquared = i * i;
				int iCubed = i * i * i;
				System.out.println(i + "\t" + iSquared + "\t" + iCubed);
			}
				
            System.out.print("\nContinue? (y/n): ");
            choice = sc.next();
            System.out.println();
			
		}

	}

}
