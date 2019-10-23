import java.util.Scanner;

public class DataTypeApp {

	public static void main(String[] args) {
		String fName = "Bob";
		String lName = "Smith";
		String fullName = fName + " " + lName;
		System.out.println(fullName);
		
		double price = 49.99;
		System.out.println(fullName + " " + price);
		
		String fn1 = "Bob";
		String ln1 = "Marley";
		String name = "";
		
		// name = name + fn1;
		name += fn1;
		name += " ";
		name += ln1; 
		System.out.println(name);
		
		int n1 = 5;
		System.out.println(n1);
		n1 += 10;
		System.out.println(n1);
		n1 -= 2;
		System.out.println(n1);
		n1 *= 2;
		System.out.println(n1);
		n1 /= 5;
		System.out.println(n1);
		
	//	String s1 = "This is para-\ngraph. It takes up\nmultiple lines and\nuses a \ttab";
		
		String s1 = "This is para-\ngraph. "
				+ "It takes up\nmultiple lines "
				+ "and\nuses a \ttab";
		System.out.println(s1);
		
		// Scanner = class, sc = variable name, 
		// new instance of Scanner, System.in = console
		Scanner sc = new Scanner(System.in);
		
//		System.out.println("Enter something: ");
//		String str = sc.nextLine();  // wait for user to hit enter
//		System.out.println("You entered: "+str);
//		
//		System.out.println("Enter a double: ");
//		double d2 = sc.nextDouble();
//		System.out.println("You entered: "+d2);
//		
//		System.out.println("Enter an int: ");
//		int i1 = sc.nextInt();
//		System.out.println("You entered: "+i1);
	
		System.out.print("a");
		System.out.print("b");
		System.out.print("c");
		System.out.print(".\n");
		
		System.out.println("Enter 4 words:");
		String str1 = sc.next();
		String str2 = sc.next();
		String str3 = sc.next();
		String str4 = sc.next();
		
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
		System.out.println(str4);
		
		sc.close();
	}

}
