package business;

import static org.junit.Assert.*;

import org.junit.Test;

public class JUnitTestingTest {

	@Test
	public void SquareTest() {
		assertEquals(16, JUnitTesting.square(4));		
		assertEquals(64, JUnitTesting.square(8));
		assertEquals(144, JUnitTesting.square(12));
	}
	
	@Test
	public void CountAsTest() {
		assertEquals(2, JUnitTesting.countA("Africa"));
		assertEquals(3, JUnitTesting.countA("Antartica"));
		assertEquals(6, JUnitTesting.countA("Annie Adams asked Andrew Akers"));
	}


}


