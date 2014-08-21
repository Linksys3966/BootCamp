import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.fail;
import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ParkingLotTest {

	private ParkingLot parkingLot2;

	@Before
	public void setUp() {
		parkingLot2 = new ParkingLot(2);
	}

	@Test
	public void checkIfParkedCarCanBeUnparkedSuccessfully() throws ParkingLotFullException, CarNotFoundException, CarAlreadyParkedException {

		Object car = new Object();
		Object token = parkingLot2.park(car);
		Object unparkedCar = parkingLot2.unpark(token);
		assertTrue(car.equals(unparkedCar));
	}

	@Test
	public void checkThatWeAreNotAbleToParkACarIfCapacityIsFull() throws ParkingLotFullException, CarAlreadyParkedException {

		parkingLot2.park(new Object());
		parkingLot2.park(new Object());
		try {
			parkingLot2.park(new Object());
			fail("Exception should be thrown For Parking Lot Full");
		} catch (ParkingLotFullException exceptionMessage) {
			assertThat(exceptionMessage.getMessage(), is("Parking Lot Full..Sorry!!!"));
		}
	}

	@Test
	public void checkForCarNotFoundException() throws ParkingLotFullException, CarNotFoundException, CarAlreadyParkedException {
		ParkingLot parkingLot3 = new ParkingLot(3);
		Object car = new Object();
		parkingLot3.park(car);
		try {
			parkingLot3.unpark(new Object());
			fail("Exception should be thrown For Car Not Found");
		} catch (CarNotFoundException exceptionMessage) {
			assertThat(exceptionMessage.getMessage(), is("Sorry car not found!!!"));
		}
	}

	@Test
	public void checkThatCarCanntBeParkedTwice() throws CarAlreadyParkedException, ParkingLotFullException {
		Object car = new Object();
		parkingLot2.park(car);
		try {
			parkingLot2.park(car);
		} catch (CarAlreadyParkedException exceptionMessage) {
			assertThat(exceptionMessage.getMessage(), is("You Cannot Park Same Car Twice"));
		}
	}

	@Test
	public void checkThatCarCannotBeUnparkedTwice() throws CarAlreadyParkedException, ParkingLotFullException, CarNotFoundException {
		Object token = parkingLot2.park(new Object());
		parkingLot2.unpark(token);
		try {
			parkingLot2.unpark(token);
			fail("Exception should be thrown For Car Not Found");
		} catch (CarNotFoundException message) {
			assertThat(message.getMessage(), is("Sorry car not found!!!"));
		}
	}
}