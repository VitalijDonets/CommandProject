package Function;

import java.text.NumberFormat;

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
    public String toPrettyString(NumberFormat nf) {
        return String.format("e^(%s)", arg.toPrettyString(nf));
    }
}
