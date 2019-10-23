
public class MathAndFormattingApp {

	public static void main(String[] args) {
		//rounding a number
		double d1 = 10.319;
		System.out.println(Math.round(d1));  // = 10

		double rd1 = (double)Math.round(d1*100) / 100; 
		System.out.println(rd1);                                 
		
		//random number between 1 and 10
		int r1 = (int) Math.random() * 10 + 1;
		System.out.println(r1);
		             
		// max / min
		System.out.println(Math.max(2, 8));
		System.out.println(Math.min(2, 8)); 
		
	}

}
