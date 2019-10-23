import java.util.Scanner;

public class GuessingGameApp {

	public static void main(String[] args) {
		final int LIMIT = 100;

		displayWelcome(LIMIT);

		Scanner sc = new Scanner(System.in);
		String choice = "y";

		while (choice.equalsIgnoreCase("y")) {
			int number = getRandomInt(LIMIT);
			int count = 1;
			while (true) {
				System.out.print("Enter number: ");
				// int guess = sc.nextInt();
				int guess = 0;
				
				guess = getIntWithinRange(sc, "Enter number: ", 1, 100);
						
			//	if (sc.hasNextInt()) {
			//		guess = sc.nextInt();
			//		sc.nextLine();
			//	} else {
			//		System.out.println("Error! Invalid number. Try again.");
			//		sc.nextLine();
			//		continue;
			//	}

			//	if (guess < 1 || guess > LIMIT) {
			//		System.out.println("Invalid guess. Try again.");
			//		continue;
			//	}

				if (guess < number - 10)
					System.out.println("Way too low! Guess again. ");
				else if (guess < number) {
					System.out.println("Too low! Guess again. ");
				} else if (guess > number + 10) {
					System.out.println("Way too high! Guess again. ");
				} else if (guess > number) {
					System.out.println("Too high! Guess again. ");
				} else {
					System.out.println("You guessed it in " + count + " tries.\n");
				
					if (count <= 3) {
						System.out.println("Great work! You are a mathematical wizard");
					} else if (count <= 7) {
						System.out.println("Not too bad! You've got some potential");
					} else {
						System.out.println("What took you so long? Maybe you should take some lessons.");
					}
					break;
				}
				count++;
			}
			
			choice = getString(sc, "Try again? (y/n) ");
		
		}
		sc.close();
		System.out.println("Bye!");
	}


	private static String getString(Scanner sc, String prompt) {
		String s = "";
		boolean isValid = false;
		while (! isValid) {
			System.out.print(prompt);
			s = sc.nextLine();
			if (s.equalsIgnoreCase("")) {
				System.out.println("Error... entry is required");
				continue;
			} else if (! s.equalsIgnoreCase("y") && ! s.equalsIgnoreCase("n")) {
				System.out.println("Must enter y or n ");
				continue;
			} else {
				isValid = true;
			}
		}
		return s;
		
	}
	
	private static void displayWelcome(int limit) {
		System.out.println("Welcome to the Guess the Number Game");
		System.out.println("++++++++++++++++++++++++++++++++++++\n");

		System.out.println("I'm thinking of a number from 1 to " + limit);
		System.out.println("Try to guess it.\n");
	}

	public static int getRandomInt(int limit) {
		double d = Math.random() * limit; // d is >= 0.0 and < limit
		int randomInt = (int) d; // convert double to int
		randomInt++; // int is >= 1 and <= limit
		return randomInt;
		
		// OR
		// int randomInt = (int) (Math.random()*100) + 1;
		// return randomInt;
	}
	
	public static int getIntWithinRange(Scanner sc, String prompt,
            int min, int max) {
        int i = 0;
        boolean isValid = false;
        while (isValid == false) {
            i = getInt(sc, prompt);
            if (i <= min) {
                System.out.println(
                        "Error! Number must be greater than " + min + ".");
            } else if (i >= max) {
                System.out.println(
                        "Error! Number must be less than " + max + ".");
            } else {
                isValid = true;
            }
        }
        return i;
    }
	
	public static int getInt(Scanner sc, String prompt) {
	    int i = 0;
	    boolean isValid = false;
	    while (isValid == false) {
	        System.out.print(prompt);
	        if (sc.hasNextInt()) {
	        	i = sc.nextInt();
	            isValid = true;
	        } else {
	            System.out.println("Error! Invalid integer. Try again.");
	        }
	        sc.nextLine();  // discard any other data entered on the line
	    }
	    return i;
	}
	
}
	
	
