package business; 

public class JUnitTesting {

	public static int square(int nbr) {
		int nbr2 = nbr * nbr;
		return nbr2;
	}
	
	public static int countA(String str) {
		
		int aCount = 0;
		for (int i = 0; i < str.length(); i++) {
			if ((str.charAt(i) == 'a') || (str.charAt(i) == 'A')) {
				aCount = aCount +1;
			}
		}
		return aCount;
	}
	
}
