/**
 * Created by dianadevasia on 19/08/14.
 */
public class Quantity {

    private Unit unit;
    private double amount;

    Quantity(double amount, Unit unit) {
        this.unit = unit;
        this.amount = amount;
    }

    public boolean equals(Quantity other) {
        if (this.unit.compareTypes(other.unit)) {
            if (other.unit.equals(this.unit))
                return other.amount == this.amount;
            else
                return other.convertTo() == this.convertTo();
        }
        System.out.println("Invalid Comparison");
        return false;
    }

    private double convertTo() {
        return this.unit.convertTo(this.amount);
    }

    public double add(Quantity other) {
        if (this.unit.compareTypes(other.unit)) {
            if (other.unit.equals(this.unit))
                return other.amount + this.amount;
            else
                return other.convertTo() + this.convertTo();
        }
        System.out.println("Invalid Comparison");
        return -1.0;
    }
}
