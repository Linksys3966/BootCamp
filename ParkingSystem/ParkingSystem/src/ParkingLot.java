import java.util.HashMap;
import java.util.Map;

//job:understands parking system of cars

public class ParkingLot {
	private int maxCapacity;
	private Map<Object, Object> parkingLotMap;

	public ParkingLot(int maxCapacity) {
		this.maxCapacity = maxCapacity;
		this.parkingLotMap = new HashMap<Object, Object>(maxCapacity);
	}

	private boolean parkingLotFull() {
		return parkingLotMap.size() == maxCapacity;
	}

	public Object park(Object car) throws ParkingLotFullException, CarAlreadyParkedException {
		if(parkingLotMap.containsValue(car))
			throw new CarAlreadyParkedException("You Cannot Park Same Car Twice");
		if (parkingLotFull())
			throw new ParkingLotFullException("Parking Lot Full..Sorry!!!");
		Object token = new Object();
		parkingLotMap.put(token, car);
		return token;
	}



	public Object unpark(Object token) throws CarNotFoundException {
		if (!parkingLotMap.containsKey(token)) throw new CarNotFoundException("Sorry car not found!!!");
		parkingLotMap.remove(token);
		return parkingLotMap.get(token);
	}
}
