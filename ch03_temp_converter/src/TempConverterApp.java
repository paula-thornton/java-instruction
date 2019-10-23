import java.util.Scanner;

public class TempConverterApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Temperature Converter");
		System.out.println();  // print a blank line

		Scanner sc = new Scanner(System.in);
        
        String choice = "y";
        while (choice.equalsIgnoreCase("y")) {
            System.out.print("Enter degrees in Fahrenheit: ");
            double fahrTemp = sc.nextDouble();
            
            double celsiusTemp = (fahrTemp - 32) * 5 / 9;
            double roundTemp = (double)Math.round(celsiusTemp*100) / 100;
            System.out.println("Degrees in Celsius: " + celsiusTemp);
            System.out.println("Celsius Temp Rounded: " + roundTemp);
            
            System.out.print("\nContinue? (y/n): ");
            choice = sc.next();
            System.out.println();
            
        }
	}

}
