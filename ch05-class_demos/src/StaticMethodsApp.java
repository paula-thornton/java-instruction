
public class StaticMethodsApp {

	public static void main(String[] args) {
		// could be pulic or private
		// static methods - don't have to create an instance
		// non-static methods - you have to create an instance
		// void means it doesn't return anything (return type)
		
		printWelcomeMessage();
		int a = sum(4,5);  // type, variable name, assignment operator, value
		System.out.println("sum is "+a);
	}
	
	private static void printWelcomeMessage() {
		// private b/c it is only called from this (module?)
		// static b/c you don't have to create an instance
		// void because it doesn't return anything
		System.out.println("Welcome to my method.");
	}
	
	private static int sum(int a, int b) {
		// returns an int
		// 2 parms
		return a + b;
	}

}
