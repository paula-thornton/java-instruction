

import java.util.Scanner;

public class NameParserApp {

    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a name: ");
        String name = sc.nextLine();
        System.out.println();
        name = name.trim();

        int idx1 = name.indexOf(" ");					// find 1st blank
        if (idx1 == -1) {
        	System.out.println("Error - invalid format");
        	
        } else {
        	int idx2 = name.indexOf(" ", idx1 + 1);	
            if (idx2 == -1) {
            	String fName = name.substring(0, idx1);
            	String lName = name.substring(idx1 + 1);
            	
        		System.out.println("First Name = " + fName);
        		System.out.println("Last Name = " + lName);
        		
            } else {
        	
            	int idx3 = name.indexOf(" ", idx2 + 1);	
            	if (idx3 == -1) {
                   	String fName = name.substring(0, idx1);
            		String mName = name.substring(idx1 + 1, idx2);
                	String lName = name.substring(idx2 + 1);
                	
            		System.out.println("First Name = " + fName);
            		System.out.println("Middle Name = " + mName);
            		System.out.println("Last Name = " + lName);
            		
            	} else {
            		
            		System.out.println("Error - invalid format");
            	}
            }

        }
    }

}
