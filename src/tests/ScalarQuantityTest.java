//Job: Understands the count for each scalar Item

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ScalarQuantityTest {

	private ScalarQuantity thirtyTwoFharaniet;
	private ScalarQuantity twoHundredTwelveFharaniet;
	private ScalarQuantity hundredCelcius;

	@Before
	public void setUp() {
		thirtyTwoFharaniet = ScalarQuantity.fharaniet(32);
		twoHundredTwelveFharaniet = ScalarQuantity.fharaniet(212);
		hundredCelcius = ScalarQuantity.celcius(100);
	}

	@Test
	public void checkForSameUnit() {
		ScalarQuantity zeroCelcius = ScalarQuantity.celcius(0);
		assertTrue(zeroCelcius.equals(ScalarQuantity.celcius(0)));
	}

	@Test
	public void checkEqualityOfTemperatureUnits() {
		ScalarQuantity zeroCelcius = ScalarQuantity.celcius(0);
		assertTrue(thirtyTwoFharaniet.equals(zeroCelcius));
		assertTrue(twoHundredTwelveFharaniet.equals(hundredCelcius));
		assertTrue(hundredCelcius.equals(twoHundredTwelveFharaniet));
	}
}