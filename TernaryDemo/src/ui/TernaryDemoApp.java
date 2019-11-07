package ui;

public class TernaryDemoApp {

	public static void main(String[] args) {
		int num = 5;
		String msg = "";
		
		if (num > 10) {
			msg = "Number > 10";
		} else {
			msg = "Number <= 10";
		}
		
		System.out.println(msg);
		
		// same logic with the ternary opeator
		msg = (num > 10) ? "Number > 10" : "Number <= 10";
		System.out.println(msg);
	}

}
