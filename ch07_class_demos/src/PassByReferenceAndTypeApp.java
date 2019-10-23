
public class PassByReferenceAndTypeApp {

	public static void main(String[] args) {
		double price = 14.99;
		price = increasePrice(price);
		System.out.println(price);

	}
	
	private static double increasePrice(double p) {
		p = p*2;
		return p;
	}

}
