public class Unit {

	private final String name;
	private final double conversionFactor;
	private final String type;

	static final Unit FEET = new Unit("ft", 12, "Length");
	static final Unit YARD = new Unit("yd", 36, "Length");
	static final Unit INCH = new Unit("in", 1, "Length");
	static final Unit MILE = new Unit("ml", 2, "Length");
	static final Unit TSP = new Unit("tsp", 1, "Weight");
	static final Unit TBSP = new Unit("tbsp", 3, "Weight");
	static final Unit OZ = new Unit("oz", 6, "Weight");
	static final Unit CUP = new Unit("cup", 48, "Weight");


	private Unit(String name, double conversionFactor, String type) {
		this.name = name;
		this.conversionFactor = conversionFactor;
		this.type = type;
	}

	public double convertTo(double amount) {
		return this.conversionFactor * amount;
	}

	public boolean compareTypes(Unit other) {
		return this.type.equals(other.type);
	}
}
