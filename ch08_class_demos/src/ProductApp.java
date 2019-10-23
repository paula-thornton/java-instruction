
public class ProductApp {

	public static void main(String[] args) {
		
		Product p1 = new Product("java", "murach's java", 57.50);
		System.out.println(p1);
		
		Product p2 = new Product("beans", "cool beans", 7.50);
		System.out.println(p2);
		
		Book b = new Book ("java", "murach's java", 57.50, "Joel Murach");
		System.out.println("Book b= " +b);
		
		Software s = new Software ("netbeans","NetBeans", 10.00, "8.2");
		System.out.println("Software s= " +s);
				
		p1 = b;
		System.out.println("Product toString: " + p1.toString());
		System.out.println("Author: " + b.getAuthor());
		
		p1 = s;
		System.out.println("Product toString: " + p1.toString());
		
	}	

}
