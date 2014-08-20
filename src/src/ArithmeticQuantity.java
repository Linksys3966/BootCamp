/**
 * Created by vivekpatil on 8/20/14.
 */
public class ArithmeticQuantity extends ScalarQuantity {

	private ArithmeticQuantity(double amount, Unit unit) {
		super(amount, unit);
	}

	public static ArithmeticQuantity inch(double amount) {
		return new ArithmeticQuantity(amount, Unit.INCH);
	}

	public static ArithmeticQuantity feet(double amount) {
		return new ArithmeticQuantity(amount, Unit.FEET);
	}

	public static ArithmeticQuantity yards(double amount) {
		return new ArithmeticQuantity(amount, Unit.YARD);
	}

	public static ArithmeticQuantity ounce(double amount) {
		return new ArithmeticQuantity(amount, Unit.OZ);
	}

	public static ArithmeticQuantity tsp(double amount) {
		return new ArithmeticQuantity(amount, Unit.TSP);
	}

	public static ArithmeticQuantity tbsp(double amount) {
		return new ArithmeticQuantity(amount, Unit.TBSP);
	}

	public static ArithmeticQuantity cup(double amount) {
		return new ArithmeticQuantity(amount, Unit.CUP);
	}

	public ScalarQuantity add(ScalarQuantity other) throws UnitMismatchException, NotAdditiveQuantityException {

		if (!super.unit.isScalarUnit()) {
			if (!this.unit.compareTypes(other.unit))
				throw new UnitMismatchException("Invalid Comparison");
			if (other.unit.equals(this.unit))
				return new ScalarQuantity(other.amount + this.amount, this.unit);
			else {
				ScalarQuantity convertedFirstQuantity = other.convertTo();
				ScalarQuantity convertedSecondQuantity = this.convertTo();
				return new ScalarQuantity(convertedFirstQuantity.amount + convertedSecondQuantity.amount, convertedFirstQuantity.unit);
			}
		}
		throw new NotAdditiveQuantityException("Not Additive Quantities");
	}
}
