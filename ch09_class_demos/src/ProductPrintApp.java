
public class ProductPrintApp {

	public static void main(String[] args) {
		Book b1 = new Book("java", "Murach's Java Programming", 5.50, "Joel Murach");
		b1.print();
		printIt(b1);

		// create a nw instance of book, a copy of b1
		Book b2 = null;
		try {
			b2 = (Book) b1.clone();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	private static void printIt(Printable p) {
		p.print();
	}

}
