import java.text.NumberFormat;
import java.util.Scanner;

public class DiceRollerApp {

	public static void main(String[] args) {

	    System.out.println("Dice Roller");
	    
	    String choice = "y";
        Scanner sc = new Scanner(System.in); 
        int die1;
        int die2;
        
	    while (choice.equalsIgnoreCase("y")) {
	    	System.out.print("Roll the dice? (y/n): ");
	    	choice = sc.nextLine();
	    	if (! choice.equalsIgnoreCase("y")) {
	    		break;
	    	}
	    	
	    	die1 = getRandomInt(6);
	    	die2 = getRandomInt(6);
	    	
	    	displayResults(die1, die2);
	    }
    	System.out.print("Thanks for playing");
	    sc.close();	
	}
	

    private static int getRandomInt(int limit) {
        double d = Math.random() * limit;   // d is >= 0.0 and < limit
        int randomInt = (int) d;            // convert double to int
        randomInt++;                        // int is >= 1 and <= limit
        return randomInt;
    }
    
    private static void displayResults(int die1, int die2) {
    
    	int total = die1 + die2;
        // format the result as a single string
    	System.out.println("Die1:  " + die1);
    	System.out.println("Die2:  " + die2);
    	System.out.println("Total: " + total);
    	
    	if (total == 2) {
    		System.out.println("Snake eyes!");
    	}
    	else {
    		if (total == 6)
    			System.out.println("Boxcars!");
    	}
    	
     	System.out.println();
     	
    }
    
 
    
}
  
