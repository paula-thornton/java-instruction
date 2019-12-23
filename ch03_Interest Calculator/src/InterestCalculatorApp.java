import java.math.BigDecimal;

import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Scanner;

public class InterestCalculatorApp {

	public static void main(String[] args) {
	
        System.out.println("Welcome to the Interest Calculator");
        System.out.println();  // print a blank line
        
		Scanner sc = new Scanner(System.in);
		
		NumberFormat pf = NumberFormat.getPercentInstance(); // nf short for number format
		//pf.setMinimumFractionDigits(3);
		pf.setMaximumFractionDigits(3);
		
		NumberFormat cf = NumberFormat.getCurrencyInstance(); // cf short for number format
		cf.setMinimumFractionDigits(2);
		cf.setMaximumFractionDigits(2);            
	
        String choice = "y";
        while (choice.equalsIgnoreCase("y")) {
        
        	System.out.print("Enter Loan Amount:   ");
        	double loanAmt = sc.nextDouble();
        
        	System.out.print("Enter Interest Rate: ");
        	double intRate = sc.nextDouble();
                
        	BigDecimal bigInterest = new BigDecimal(loanAmt * intRate);
        	System.out.println("Big Interest " + bigInterest);
		
        	bigInterest = bigInterest.setScale(2, RoundingMode.HALF_UP);
        	System.out.println("Big interest rounded is " + bigInterest);
		
        	System.out.println("\nLoan amount:     " + cf.format(loanAmt) );
        	System.out.println(  "Interest Rate:   " + pf.format(intRate) );
        	System.out.println(  "Interest:        " + cf.format(bigInterest) );
        	
            System.out.print("\nContinue? (y/n): ");
            choice = sc.next();
            System.out.println();
        
        }

	}

}
