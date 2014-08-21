//Job: Understands the count for each arithemetic Item
public class ArithmeticQuantity extends ScalarQuantity {

	private ArithmeticQuantity(double amount, Unit unit) {
		super(amount, unit);
	}

	protected static ArithmeticQuantity inch(double amount) {
		return new ArithmeticQuantity(amount, Unit.INCH);
	}

	protected static ArithmeticQuantity feet(double amount) {
		return new ArithmeticQuantity(amount, Unit.FEET);
	}

	protected static ArithmeticQuantity yards(double amount) {
		return new ArithmeticQuantity(amount, Unit.YARD);
	}

	protected static ArithmeticQuantity ounce(double amount) {
		return new ArithmeticQuantity(amount, Unit.OZ);
	}

	protected static ArithmeticQuantity tsp(double amount) {
		return new ArithmeticQuantity(amount, Unit.TSP);
	}

	protected static ArithmeticQuantity tbsp(double amount) {
		return new ArithmeticQuantity(amount, Unit.TBSP);
	}

	protected static ArithmeticQuantity cup(double amount) {
		return new ArithmeticQuantity(amount, Unit.CUP);
	}

	protected ArithmeticQuantity add(ArithmeticQuantity other) throws UnitMismatchException {

		if (!this.unit.compareTypes(other.unit))
			throw new UnitMismatchException("Invalid Comparison");
		if (!other.unit.equals(this.unit)) {
			double convertedSecondQuantity = other.convertTo(this.unit);
			return new ArithmeticQuantity(convertedSecondQuantity + this.amount, this.unit);
		}
		return new ArithmeticQuantity(other.amount + this.amount, this.unit);
	}
}
