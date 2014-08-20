// job: understands different measurements for quantities
public class Unit {

	private final String name;
	private final Unit baseUnit;
	private final double multiplicationFactor;
	private final double additionFactor;
	private final Object Type;
	private static final Object LENGTH = new Object();
	private static final Object WEIGHT = new Object();
	private static final Object TEMPRATURE = new Object();
	static final Unit FEET = new Unit("ft", Unit.INCH, 12, 0, LENGTH);
	static final Unit YARD = new Unit("yd", Unit.INCH, 36, 0, LENGTH);
	static final Unit INCH = new Unit("in", Unit.INCH, 1, 0, LENGTH);
	static final Unit MILE = new Unit("ml", Unit.INCH, 2, 0, LENGTH);
	static final Unit TSP = new Unit("tsp", Unit.TSP, 1, 0, WEIGHT);
	static final Unit TBSP = new Unit("tbsp", Unit.TSP, 3, 0, WEIGHT);
	static final Unit OZ = new Unit("oz", Unit.TSP, 6, 0, WEIGHT);
	static final Unit CUP = new Unit("cup", Unit.TSP, 48, 0, WEIGHT);
	static final Unit CELCIUS = new Unit("celcius", Unit.CELCIUS, 1, 0, TEMPRATURE);
	static final Unit FHARANIET = new Unit("fharaniet", Unit.CELCIUS, (1 / 1.8), (-32.0), TEMPRATURE);


	private Unit(String name, Unit baseUnit, double multiplicationFactor, double additionFactor, Object Type) {
		this.name = name;
		this.baseUnit = baseUnit;
		this.multiplicationFactor = multiplicationFactor;
		this.additionFactor = additionFactor;
		this.Type = Type;
	}

	public double convertTo(double amount) {
		return (this.multiplicationFactor * (amount + additionFactor));

	}

	public boolean compareTypes(Unit other) {
		return this.Type.equals(other.Type);
	}

	public Unit getBaseUnit() {
		return baseUnit;
	}

	public boolean isScalarUnit() {
		return this.Type.equals(Unit.TEMPRATURE);
	}
}
