import java.util.Scanner;

public class GradeConverterApp {

	public static void main(String[] args) {
			
		Scanner sc = new Scanner(System.in);
				
		String choice = "y";
		String letterGrade = " ";
		int    numericalGrade = 0;
		
		System.out.println("Welcome to the Letter Grade Converter");
        
        while (choice.equalsIgnoreCase("y")) {
        	System.out.print("\nEnter numerical grade:  ");
        	numericalGrade = sc.nextInt();
        	
        	if (numericalGrade >= 88) {
        		letterGrade = "A";
        	} else if (numericalGrade >= 80) {
        		letterGrade = "B";
        	} else if (numericalGrade >= 67) {
        		letterGrade = "C";
        	} else if (numericalGrade >= 60) {
        		letterGrade = "D";
        	} else {
        		letterGrade = "F";
        	}
        	System.out.println("Letter grade: " + letterGrade);
        	System.out.print("\nContinue? (y/n): ");
        	choice = sc.next();
        }
        System.out.println("\nExiting program.");
        sc.close();

	}

}
