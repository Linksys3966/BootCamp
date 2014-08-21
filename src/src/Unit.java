// job: understands different measurements for quantities
public class Unit {

	private final String name;
	private final double multiplicationFactor;
	private final double additionFactor;
	private final Object Type;
	private static final Object LENGTH = new Object();
	private static final Object WEIGHT = new Object();
	private static final Object TEMPRATURE = new Object();
	public static final Unit FEET = new Unit("feet", 12, 0, LENGTH);
	public static final Unit YARD = new Unit("yardd", 36, 0, LENGTH);
	public static final Unit INCH = new Unit("inch", 1, 0, LENGTH);
	public static final Unit MILE = new Unit("mile", 2, 0, LENGTH);
	public static final Unit TSP = new Unit("tsp", 1, 0, WEIGHT);
	public static final Unit TBSP = new Unit("tbsp", 3, 0, WEIGHT);
	public static final Unit OZ = new Unit("ounce", 6, 0, WEIGHT);
	public static final Unit CUP = new Unit("cup", 48, 0, WEIGHT);
	public static final Unit CELCIUS = new Unit("celcius", 1, 0, TEMPRATURE);
	public static final Unit FHARANIET = new Unit("fharaniet", (1 / 1.8), (32.0), TEMPRATURE);


	private Unit(String name, double multiplicationFactor, double additionFactor, Object Type) {
		this.name = name;

		this.multiplicationFactor = multiplicationFactor;
		this.additionFactor = additionFactor;
		this.Type = Type;
	}

	public double convertToResultUnit(double amount, Unit resultUnit) {
		return ((amount - additionFactor) * (multiplicationFactor)) / (resultUnit.multiplicationFactor) + (resultUnit.additionFactor);
	}

	public boolean compareTypes(Unit other) {
		return this.Type.equals(other.Type);
	}
}
