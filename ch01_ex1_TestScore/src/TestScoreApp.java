import java.text.NumberFormat;
import java.util.Scanner;

public class TestScoreApp {

    public static void main(String[] args) {
        // display operational messages
        System.out.println("Enter test scores that range from 0 to 100.");
        System.out.println("To end the program, enter 999.");
        System.out.println();  // print a blank line

        // initialize variables and create a Scanner object
        int scoreTotal = 0;
        int scoreCount = 0;
        int testScore = 0;
        int minScore = 0;
        int maxScore = 0;
        
		NumberFormat nf = NumberFormat.getNumberInstance(); // nf short for number format
		
		nf.setMinimumFractionDigits(1);
		nf.setMaximumFractionDigits(1);
        
        @SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

        // get a series of test scores from the user
       // while (testScore <= 100) {
        while (testScore != 999) {
            // get the input from the user
            System.out.print("Enter score: ");
            testScore = sc.nextInt();

            // accumulate score count and score total
            if (testScore <= 100) {
               // scoreCount = scoreCount + 1;
                scoreCount++;
                if (scoreCount == 1) {
                	minScore = testScore;
                	maxScore = testScore;
                }
               // scoreTotal = scoreTotal + testScore;
                scoreTotal += testScore;
                minScore = Math.min(minScore, testScore);
                maxScore = Math.max(maxScore, testScore);
            }
            else if (testScore != 999)
            {
                System.out.println("Invalid entry. Score skipped.");	
        	}
        }

        // display the score count, score total, and average score
        double averageScore = 0;
        if (scoreCount > 0) {
            averageScore = (double) scoreTotal / scoreCount;       	
        }

        String message = "\n"
                + "Score count:   " + scoreCount + "\n"
                + "Score total:   " + scoreTotal + "\n"
                + "Average score: " + nf.format(averageScore) + "\n"
                + "Max score:     " + maxScore + "\n"
                + "Min score:     " + minScore + "\n";
         
        System.out.println(message);
    }
}