import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

// job: understands comparison of units
public class ArithmaticQuantityTest {

	private ArithmeticQuantity FourFeet;
	private ArithmeticQuantity FourTbsp;
	private ArithmeticQuantity EightOz;
	private ArithmeticQuantity FourtyEightYards;

	@Before
	public void setUp() {
		FourFeet = ArithmeticQuantity.feet(4);
		FourTbsp = ArithmeticQuantity.tbsp(4);
		EightOz = ArithmeticQuantity.ounce(8);
		FourtyEightYards = ArithmeticQuantity.inch(48);
	}

	@Test
	public void checkForSameUnit() {
		assertTrue(FourFeet.equals(ArithmeticQuantity.feet(4)));
		assertTrue(FourTbsp.equals(ArithmeticQuantity.tbsp(4)));
	}

	@Test
	public void checkEqualityOfLengthUnits() {
		ArithmeticQuantity FourtyEightYards = ArithmeticQuantity.yards(48.0);
		ArithmeticQuantity OneFortyFourFeet = ArithmeticQuantity.feet(144.0);
		assertTrue(FourtyEightYards.equals(OneFortyFourFeet));
		assertTrue(FourFeet.equals(this.FourtyEightYards));
	}

	@Test
	public void checkEqualityOfWeightUnits() {
		ArithmeticQuantity FourtyEight_yards = ArithmeticQuantity.yards(48);
		ArithmeticQuantity OneCup = ArithmeticQuantity.cup(1);
		ArithmeticQuantity TwelveTsp = ArithmeticQuantity.tsp(12);
		assertTrue(FourTbsp.equals(TwelveTsp));
		assertTrue(EightOz.equals(OneCup));
		assertFalse(EightOz.equals(FourtyEight_yards));
	}

	@Test(expected = UnitMismatchException.class)
	public void checkForAdditionOfArithemeticUnits() throws UnitMismatchException {
		ArithmeticQuantity TwoInch = ArithmeticQuantity.inch(2);
		assertEquals(true, TwoInch.add(TwoInch).equals(ArithmeticQuantity.inch(4.0)));
		assertEquals(true, FourFeet.add(FourFeet).equals(ArithmeticQuantity.feet(8.0)));
		assertEquals(true, EightOz.add(FourTbsp).equals(ArithmeticQuantity.ounce(10.0)));
		assertEquals(true, FourFeet.add(ArithmeticQuantity.inch(12)).equals(ArithmeticQuantity.feet(5)));
		assertEquals(true, EightOz.add(FourFeet).equals(new UnitMismatchException("Invalid Addition")));
	}

	@Test
	public void checkExceptionMessageForRaisedExceptions() throws UnitMismatchException {
		try {
			EightOz.add(FourFeet);
		} catch (UnitMismatchException exceptionMessage) {
			assertThat(exceptionMessage.getMessage(), is("Invalid Comparison"));
		}
	}

	@Test
	public void checkEqualityofDifferentArithmeticUnits() throws UnitMismatchException {
		ArithmeticQuantity TwelveInch = ArithmeticQuantity.inch(12);
		ArithmeticQuantity TwoFeet = ArithmeticQuantity.feet(2);
		assertEquals(true, TwelveInch.add(TwelveInch).equals(TwoFeet));
	}
}