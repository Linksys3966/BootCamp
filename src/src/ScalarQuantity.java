//Job: understands the count for each item
public class ScalarQuantity {
	protected Unit unit;
	protected double amount;

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
		if (other.unit.equals(this.unit))
			return other.amount == this.amount;
		return other.convertTo().amount == this.convertTo().amount;
	}

	protected ScalarQuantity convertTo() {
		Unit unit = this.unit.getBaseUnit();
		return new ScalarQuantity(this.unit.convertTo(this.amount), unit);
	}
}
