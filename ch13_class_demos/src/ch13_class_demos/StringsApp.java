package ch13_class_demos;

public class StringsApp {

	public static void main(String[] args) {

		String str1 = "Murach's Java Programming";
		if (str1.startsWith("mur")) {
			System.out.println("Not case sensitive");
		} else {
			System.out.println("Case sensitive");
		}
		
		String name1 = "bob l smith";
		
		System.out.println("name1 = " + name1);
		System.out.println("length = " + name1.length());
		System.out.println(name1.indexOf("b") );		// find 1st b
		System.out.println(name1.indexOf("b", 1) );		// find 2nd b, starting w/ index = 1
	
		int idx1 = name1.indexOf(" ");					// find 1st blank
		int idx2 = name1.indexOf(" ", idx1 + 1);		// find 2nd blank, start w/ pos after 1st blank
		String fName = name1.substring(0, idx1);
		String mi = name1.substring(idx1 + 1, idx2);
		String lName = name1.substring(idx2 + 1);
		System.out.println("fName = " + fName);
		System.out.println("mi = " + mi);
		System.out.println("lName = " + lName);
		
		String name2 = "    Sue    Johnson   ";
		System.out.println(name2);
		System.out.println(name2.length() );
		
		String name3 = name2.trim();
		System.out.println(name3);
		System.out.println(name3.length() );
		
		String name4 = "###b##o#b####";
		String name5 = name4.replace("#", " ");
		System.out.println(name5);
		
		String[] name1Array = name1.split(" ");
		for (String s: name1Array) {
			System.out.println(s);
		}
		
	}
	
}
