package Function;

import java.text.NumberFormat;
import java.util.Objects;

public class Ln implements Function{
    private final Function arg;

    public Ln(Function arg) {
        this.arg = arg;
    }

    public static Ln of(Function f){
        return new Ln(f);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ln ln = (Ln) o;
        return Objects.equals(arg, ln.arg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(arg);
    }

    @Override
    public double calculate(double x) {
        return Math.log(arg.calculate(x));
    }

    @Override
    public Function dx() {
        return new Product(Pow.of(arg, -1), arg.dx());
    }

    @Override
    public String toPrettyString(NumberFormat nf) {
        return String.format("ln(%s)", arg.toPrettyString(nf));
    }
}
