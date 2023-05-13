package Function;

import java.text.NumberFormat;
import java.util.Objects;

public class Sin implements Function{
    private final Function arg;

    public Sin(Function arg) {
        this.arg = arg;
    }
    public static Sin of(Function f){
        return new Sin(f);
    }
    @Override
    public double calculate(double x) {
        return Math.sin(arg.calculate(x));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sin sin = (Sin) o;
        return Objects.equals(arg, sin.arg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(arg);
    }

    @Override
    public Function dx() {
        return new Product(Cos.of(arg), arg.dx());
    }

    @Override
    public String toPrettyString(NumberFormat nf) {
        return String.format("sin(%s)", arg.toPrettyString(nf));
    }
}
