package Function;

import java.text.NumberFormat;
import java.util.Objects;

public class Pow implements Function{
    private final Function base;
    private final double power;

    public Pow(Function base, double power) {
        this.base = base;
        this.power = power;
    }
    public static Pow of(Function base, double power) {
        return new Pow(base, power);
    }
    @Override
    public double calculate(double x) {
        return Math.pow(base.calculate(x), power);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pow pow = (Pow) o;
        return Double.compare(pow.power, power) == 0 && Objects.equals(base, pow.base);
    }

    @Override
    public int hashCode() {
        return Objects.hash(base, power);
    }

    @Override
    public Function dx() {
        return new Product(Const.of(power), Pow.of(base, power - 1), base.dx());
    }

    @Override
    public String toPrettyString(NumberFormat nf) {
        if(power != 1) return String.format("(%s)^(" + power + ")", base.toPrettyString(nf));
        else return String.format("(%s)", base.toPrettyString(nf));
    }
}
