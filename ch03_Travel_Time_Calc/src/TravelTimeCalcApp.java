import java.util.Scanner;

public class TravelTimeCalcApp {

	public static void main(String[] args) {
		
		System.out.println("Welcome to the Travel Time Calculator");
		System.out.println();  // print a blank line

		Scanner sc = new Scanner(System.in);
        
        String choice = "y";
        while (choice.equalsIgnoreCase("y")) {
            System.out.print("Enter miles:          ");
            double miles = sc.nextDouble();
            
            System.out.print("Enter miles per hour: ");
            double mph = sc.nextDouble();
            
            int hours = (int) (miles/mph);
            int minutes = (int)( miles % mph / mph * 60 );
               
            // another way to do this
            // double hours = miles / mph;
            // int min = (int)(hours * 60);
            // int hoursInt = min / 60'
            // min %= 60 
            
            System.out.println("\nEstimated travel time");
            System.out.println("---------------------");
            System.out.println("Hours:   " + hours);
            System.out.println("Minutes: " + minutes);
            
            System.out.print("\nContinue? (y/n): ");
            choice = sc.next();
            System.out.println();
            
        }
        sc.close();
        System.out.println("Thanks for playing");
	}

}


