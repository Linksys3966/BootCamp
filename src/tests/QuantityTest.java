import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

// job: understands comparison of units
public class QuantityTest {

	Quantity Four_ft;
	Quantity Four_ft_Other;
	Quantity FourtyEight_yards;
	Quantity Four_tbsp;
	Quantity Eight_oz;
	Quantity One_cup;
	Quantity Four_Eight_Inches;
	Quantity Twelve_Tsp;
	Quantity OneFortyFour_Feet;


	@Before
	public void setUp() {
		Four_ft = new Quantity(4, Unit.FEET);
		Four_ft_Other = new Quantity(4, Unit.FEET);
		FourtyEight_yards = new Quantity(48, Unit.YARD);
		Four_tbsp = new Quantity(4, Unit.TBSP);
		Eight_oz = new Quantity(8, Unit.OZ);
		One_cup = new Quantity(1, Unit.CUP);
		Four_Eight_Inches = new Quantity(48, Unit.INCH);
		Twelve_Tsp = new Quantity(12, Unit.TSP);
		OneFortyFour_Feet = new Quantity(144, Unit.FEET);
	}

	@Test
	public void checkForSameUnit() {
		assertTrue(Four_ft.equals(Four_ft_Other));
		assertTrue(Four_tbsp.equals(Four_tbsp));

	}

	@Test
	public void checkForDifferentUnit() {
		assertTrue(FourtyEight_yards.equals(OneFortyFour_Feet));
		assertTrue(Four_ft.equals(Four_Eight_Inches));
		assertTrue(Four_tbsp.equals(Twelve_Tsp));
		assertTrue(Eight_oz.equals(One_cup));
		assertFalse(Eight_oz.equals(FourtyEight_yards));
	}

	@Test
	public void checkForAdditionOfUnits() {
		assertEquals(true, Four_ft.add(Four_ft) == 8.0);
		assertEquals(true, Eight_oz.add(Four_tbsp) == 60.0);
		assertEquals(true, Eight_oz.add(Four_ft) == -1.0);
	}
}
