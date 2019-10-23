import java.util.Scanner;

public class StudentRegistrationApp {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter first name:  ");
		String firstName = sc.next();
		System.out.print("Enter last name:  ");
		String lastName = sc.next();
		System.out.print("Enter year of birth:  ");
		int birthYear = sc.nextInt();
		
		System.out.println("\nWelcome " + firstName + " " + lastName + "!" );
		System.out.println("Your registration is complete.");
		System.out.println("Your temporary password is " + firstName + "*" + birthYear);
		
	}
}
