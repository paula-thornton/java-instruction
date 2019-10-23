import java.util.InputMismatchException;
import java.util.Scanner;

public class CommonDenominatorApp2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Welcome to the Common Divisor Finder");
		System.out.println(); // print a blank line

		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			// System.out.print("Enter first number: ");
			// int y = sc.nextInt();
			int y = getInt("Enter first number:  ", sc);

			// System.out.print("Enter second number: ");
			// int x = sc.nextInt();
			int x = getInt("Enter second number: ", sc);

			while (x != 0) {

				while (y >= x) {
					y = y - x; // same as: y -= x;
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

	private static int getInt(String prompt, Scanner sc) {
		boolean isValid = false;
		int i = 0;	
	
		while (!isValid) {
			try {
				System.out.print(prompt);
				i = sc.nextInt();
				isValid = true;
			} catch (InputMismatchException ime) {
				System.out.println("Invalid entry. Try again");
				sc.nextLine(); // discard input
				continue;
			}
		}
		return i;


	}

}
