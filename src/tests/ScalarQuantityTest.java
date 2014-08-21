//Job: Understands the count for each scalar Item

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ScalarQuantityTest {

	private ScalarQuantity ThirtyTwoFharaniet;
	private ScalarQuantity TwoHundredTwelveFharaniet;
	private ScalarQuantity HundredCelcius;

	@Before
	public void setUp() {
		ThirtyTwoFharaniet = ScalarQuantity.fharaniet(32);
		TwoHundredTwelveFharaniet = ScalarQuantity.fharaniet(212);
		HundredCelcius = ScalarQuantity.celcius(100);
	}

	@Test
	public void checkForSameUnit() {
		ScalarQuantity ZeroCelcius = ScalarQuantity.celcius(0);
		assertTrue(ZeroCelcius.equals(ScalarQuantity.celcius(0)));
	}

	@Test
	public void checkEqualityOfTemperatureUnits() {
		ScalarQuantity ZeroCelcius = ScalarQuantity.celcius(0);
		assertTrue(ThirtyTwoFharaniet.equals(ZeroCelcius));
		assertTrue(TwoHundredTwelveFharaniet.equals(HundredCelcius));
		assertTrue(HundredCelcius.equals(TwoHundredTwelveFharaniet));
	}
}