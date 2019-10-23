import java.text.NumberFormat;

public class NumberFormatApp {

	public static void main(String[] args) {
		double d1 = .25888888;
		NumberFormat cf = NumberFormat.getCurrencyInstance(); // cf short for currency format
		NumberFormat pf = NumberFormat.getPercentInstance();  // pf short for percent format
		pf.setMinimumFractionDigits(2);
		pf.setMaximumFractionDigits(4);
		
		System.out.println(cf.format(d1));
		System.out.println(pf.format(d1));

	}

}
