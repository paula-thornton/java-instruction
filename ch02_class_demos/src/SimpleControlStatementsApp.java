
public class SimpleControlStatementsApp {

	public static void main(String[] args) {
		int a = 5;
		int b = 10;
		int c = 5;
		
		if (a < b) {
			System.out.println("a less than b");
		}
		
		if (a == c) {
			System.out.println("a equals c");
		}
		
		if (a > b) {
			System.out.println("a less than b");
		}
		
		String s1 = "abc";
		String s2 = "abc";
		
		// should NOT work, but sometimes it does
		if (s1 == s2) {
			System.out.println("s1 == s2");
		}

		// proper way to compare strings
		if (s1.equals(s2)) {
			System.out.println("s1.equals(s2)");
		}
	}

}
