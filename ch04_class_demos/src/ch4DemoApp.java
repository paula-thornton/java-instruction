
public class ch4DemoApp {

	public static void main(String[] args) {
	// switch demo
		
		int a=2;
		switch (a) {
		case 1:
			System.out.println("a is 1");
			break;
		case 2:
			System.out.println("a is 2");
			break;
		case 3:
			System.out.println("a is 3");
			break;
		case 4:
			System.out.println("a is 4");
			break;
		case 5:
			System.out.println("a is 5");
			break;
		default:
			System.out.println("a is none of the above");
		}
		
		// while loop
		int i = 1;
		int months = 10;
		
		while (i <= months) {
			System.out.println("Running! i = " + i);
			i++;
		}
		
		//do while loop - always executes at least 1
		do {
			System.out.println("Running! i = " + i);
		} while (i <= months);
		
		// for loop - print yahoo 10 times
		for (int j = 1; j <= 10; j++) {
			System.out.println("Yahoo " + j);
		}
		
		// for loop countdown
		for (int k=5; k>0; k--) {
			System.out.println("Running! k = " + k);
		}
		
		
	}

}
