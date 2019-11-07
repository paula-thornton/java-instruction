package ui;

import util.Console;
import business.JUnitTesting;

public class JUnitTestingApp {

	public static void main(String[] args) {
	
		System.out.println("Welcome to Junit Testing App");
		
		int i = Console.getInt("Enter an integer: ");
		int iSquared = JUnitTesting.square(i);
		System.out.println(i + " squared = " + iSquared + "\n");
		
		String str = Console.getString("Enter a string: ");
		int nbr = JUnitTesting.countA(str);
		System.out.println("String contains " + nbr + " A's");
		
	}

}
