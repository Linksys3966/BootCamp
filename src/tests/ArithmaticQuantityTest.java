import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

// job: understands comparison of units
public class ArithmaticQuantityTest {

	private ArithmeticQuantity fourFeet;
	private ArithmeticQuantity fourTbsp;
	private ArithmeticQuantity eightOz;
	private ArithmeticQuantity fourtyEightYards;

	@Before
	public void setUp() {
		fourFeet = ArithmeticQuantity.feet(4);
		fourTbsp = ArithmeticQuantity.tbsp(4);
		eightOz = ArithmeticQuantity.ounce(8);
		fourtyEightYards = ArithmeticQuantity.inch(48);
	}

	@Test
	public void checkForSameUnit() {
		assertTrue(fourFeet.equals(ArithmeticQuantity.feet(4)));
		assertTrue(fourTbsp.equals(ArithmeticQuantity.tbsp(4)));
	}

	@Test
	public void checkEqualityOfLengthUnits() {
		ArithmeticQuantity fourtyEightYards = ArithmeticQuantity.yards(48.0);
		ArithmeticQuantity oneFortyFourFeet = ArithmeticQuantity.feet(144.0);
		assertTrue(fourtyEightYards.equals(oneFortyFourFeet));
		assertTrue(fourFeet.equals(this.fourtyEightYards));
	}

	@Test
	public void checkEqualityOfWeightUnits() {
		ArithmeticQuantity fourtyEight_yards = ArithmeticQuantity.yards(48);
		ArithmeticQuantity oneCup = ArithmeticQuantity.cup(1);
		ArithmeticQuantity twelveTsp = ArithmeticQuantity.tsp(12);
		assertTrue(fourTbsp.equals(twelveTsp));
		assertTrue(eightOz.equals(oneCup));
		assertFalse(eightOz.equals(fourtyEight_yards));
	}

	@Test(expected = UnitMismatchException.class)
	public void checkForAdditionOfArithemeticUnits() throws UnitMismatchException {
		ArithmeticQuantity twoInch = ArithmeticQuantity.inch(2);
		assertEquals(true, twoInch.add(twoInch).equals(ArithmeticQuantity.inch(4.0)));
		assertEquals(true, fourFeet.add(fourFeet).equals(ArithmeticQuantity.feet(8.0)));
		assertEquals(true, eightOz.add(fourTbsp).equals(ArithmeticQuantity.ounce(10.0)));
		assertEquals(true, fourFeet.add(ArithmeticQuantity.inch(12)).equals(ArithmeticQuantity.feet(5)));
		assertEquals(true, eightOz.add(fourFeet).equals(new UnitMismatchException("Invalid Addition")));
	}

	@Test
	public void checkExceptionMessageForRaisedExceptions() throws UnitMismatchException {
		try {
			eightOz.add(fourFeet);
		} catch (UnitMismatchException exceptionMessage) {
			assertThat(exceptionMessage.getMessage(), is("Invalid Comparison"));
		}
	}

	@Test
	public void checkEqualityofDifferentArithmeticUnits() throws UnitMismatchException {
		ArithmeticQuantity twelveInch = ArithmeticQuantity.inch(12);
		ArithmeticQuantity twoFeet = ArithmeticQuantity.feet(2);
		assertEquals(true, twelveInch.add(twelveInch).equals(twoFeet));
	}
}