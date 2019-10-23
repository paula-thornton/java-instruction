import java.text.NumberFormat;
import java.util.Scanner;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class MPGApp {

    public static void main(String[] args) {
        System.out.println("Welcome to the Miles Per Gallon calculator");
        System.out.println();  // print a blank line
        
        @SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		NumberFormat nf = NumberFormat.getNumberInstance(); // nf short for number format
		
		nf.setMinimumFractionDigits(3);
		nf.setMaximumFractionDigits(3);
        
        String choice = "y";
        while (choice.equalsIgnoreCase("y")) {
            System.out.print("Enter miles driven: ");
            double miles = sc.nextDouble();
            
            System.out.print("Enter gallons of gas used: ");
            double gallons = sc.nextDouble();
            
            double mpg = miles/gallons;
            System.out.println("Miles per gallon is " + mpg + ".");
            System.out.println(); 
            
           // int rd1 = (int)Math.round(mpg);
           // System.out.println("Miles per gallon rounded to whole number = " + rd1);
            
           //	double rd2 = (double)Math.round(mpg*100) / 100; 
           // System.out.println("Miles per gallon rounded to 2 dec places = " + rd2);

    		System.out.println("Miles per gallon rounded is " + nf.format(mpg));
    		//System.out.println(pf.format(d1));
    		
    		BigDecimal bigMPG = new BigDecimal(miles/gallons);
    		System.out.println("Big Miles per gallon is " + bigMPG);
    		
    		bigMPG = bigMPG.setScale(3, RoundingMode.HALF_UP);
    		System.out.println("Big Miles per gallon rounded is " + bigMPG);
            
            System.out.print("\nCalculate another MPG? (y/n): ");
            choice = sc.next();
            System.out.println();
        }
    }
    
}
