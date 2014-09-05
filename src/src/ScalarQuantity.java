//Job: understands the count for each scalar item
public class ScalarQuantity {
	protected Unit unit;
	public  double amount;

	protected ScalarQuantity(double amount, Unit unit) {
		this.unit = unit;
		this.amount = amount;
	}

	public static ScalarQuantity celcius(double amount) {
		return new ScalarQuantity(amount, Unit.CELCIUS);
	}

	public static ScalarQuantity fharaniet(double amount) {
		return new ScalarQuantity(amount, Unit.FHARANIET);
	}

	public boolean equals(ScalarQuantity other) {
		if (!this.unit.compareTypes(other.unit))
			return false;
		if (other.unit.equals(unit))
			return other.amount == amount;
		return other.convertTo(unit) == amount;
	}

	protected double convertTo(Unit unit) {
		return this.unit.convertToResultUnit(this.amount, unit);
	}
}
