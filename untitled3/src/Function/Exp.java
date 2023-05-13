package Function;

import java.text.NumberFormat;
import java.util.Objects;

public class Exp implements Function{
    private final Function arg;

    public Exp(Function arg) {
        this.arg = arg;
    }
    public static Exp of(Function f) {
        return new Exp(f);
    }

    @Override
    public double calculate(double x) {
        return Math.exp(arg.calculate(x));
    }

    @Override
    public Function dx() {
        return Product.of(new Exp(arg), arg.dx());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exp exp = (Exp) o;
        return Objects.equals(arg, exp.arg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(arg);
    }

    @Override
    public String toPrettyString(NumberFormat nf) {
        return String.format("e^(%s)", arg.toPrettyString(nf));
    }
}
