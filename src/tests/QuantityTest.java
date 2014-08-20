import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

// job: understands comparison of units
public class QuantityTest {

	private ArithmeticQuantity Four_ft;
	private ArithmeticQuantity Four_tbsp;
	private ArithmeticQuantity Eight_oz;
	private ArithmeticQuantity Four_Eight_Inches;
	private ScalarQuantity ThirtyTwo_Fharaniet;
	private ScalarQuantity TwoHundredTwelve_Fharaniet;
	private ScalarQuantity Hundred_Celcius;


	@Before
	public void setUp() {
		Four_ft = ArithmeticQuantity.feet(4);
		Four_tbsp = ArithmeticQuantity.tbsp(4);
		Eight_oz = ArithmeticQuantity.ounce(8);
		Four_Eight_Inches = ArithmeticQuantity.inch(48);
		ThirtyTwo_Fharaniet = ScalarQuantity.fharaniet(32);
		TwoHundredTwelve_Fharaniet = ScalarQuantity.fharaniet(212);
		Hundred_Celcius = ScalarQuantity.celcius(100);
	}

	@Test
	public void checkForSameUnit() {
		ScalarQuantity Zero_Celcius = ScalarQuantity.celcius(0);
		assertTrue(Four_ft.equals(ArithmeticQuantity.feet(4)));
		assertTrue(Four_tbsp.equals(ArithmeticQuantity.tbsp(4)));
		assertTrue(Zero_Celcius.equals(ScalarQuantity.celcius(0)));
	}

	@Test
	public void checkEqualityOfLengthUnits() {
		ArithmeticQuantity FourtyEight_yards = ArithmeticQuantity.yards(48.0);
		ArithmeticQuantity OneFortyFour_Feet = ArithmeticQuantity.feet(144.0);
		assertTrue(FourtyEight_yards.equals(OneFortyFour_Feet));
		assertTrue(Four_ft.equals(Four_Eight_Inches));
	}

	@Test
	public void checkEqualityOfWeightUnits() {
		ArithmeticQuantity FourtyEight_yards = ArithmeticQuantity.yards(48);
		ArithmeticQuantity One_cup = ArithmeticQuantity.cup(1);
		ArithmeticQuantity Twelve_Tsp = ArithmeticQuantity.tsp(12);
		assertTrue(Four_tbsp.equals(Twelve_Tsp));
		assertTrue(Eight_oz.equals(One_cup));
		assertFalse(Eight_oz.equals(FourtyEight_yards));
	}

	@Test
	public void checkEqualityOfTemperatureUnits() {
		ScalarQuantity Zero_Celcius = ScalarQuantity.celcius(0);
		assertTrue(ThirtyTwo_Fharaniet.equals(Zero_Celcius));
		assertTrue(TwoHundredTwelve_Fharaniet.equals(Hundred_Celcius));
	}

	@Test(expected = UnitMismatchException.class)
	public void checkForAdditionOfArithemeticUnits() throws UnitMismatchException, NotAdditiveQuantityException {
		ArithmeticQuantity Two_Inch = ArithmeticQuantity.inch(2);
		assertEquals(true, Two_Inch.add(Two_Inch).equals(ArithmeticQuantity.inch(4.0)));
		assertEquals(true, Four_ft.add(Four_ft).equals(ArithmeticQuantity.feet(8.0)));
		assertEquals(true, Eight_oz.add(Four_tbsp).equals(ArithmeticQuantity.tsp(60.0)));
		assertEquals(true, Eight_oz.add(Four_ft).equals(new UnitMismatchException("Invalid Addition")));
	}

//	@Test
//	public void createTemperatureAsArithmaticaQuantity() throws UnitMismatchException, NotAdditiveQuantityException{
//		ScalarQuantity Celcius100 = ScalarQuantity.celcius(100);
//		ScalarQuantity Celcius200 = ScalarQuantity.celcius(200);
//		//Celcius100.add(Celcius200)
//		//Cups100 = new ScalarQuantity(100, Unit.CUP)
//	}
}
