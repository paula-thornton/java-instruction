
public class EqualsDemo {

	public static void main(String[] args) {
		
		String s1 = "abc";
		String s2 = "abc";
	//	if (s1 == s2) {   // NOT pointing to same object
	//		System.out.println("s1 and s2 are the same object");
		if (s1.equals(s2)) {
			System.out.println("s1 and s2 have the same values");
		} else {
			System.out.println("s1 and s2 don't have the same values");
		}		
		
		
		Book b1 = new Book("java","Murach's Java", 59.50, "Joel Murach");
		Book b2 = new Book("java","Murach's Java", 59.50, "Joel Murach");
		if (b1 == b2) {   // NOT pointing to same object
			System.out.println("b1 and b2 are the same object");
		} else if (b1.equals(b2)) {
			System.out.println("b1 and b2 have the same values");
		} else {
			System.out.println("b1 and b2 have are not the same and don't have the same values");
		}		
	}

}
