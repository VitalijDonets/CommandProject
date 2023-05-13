package Function;

import java.text.NumberFormat;
import java.util.Objects;

public class Abs implements Function {
    private final Function arg;
    public Abs(Function arg) {
        this.arg = arg;
    }
    public static Abs of(Function f){
        return new Abs(f);
    }
    @Override
    public double calculate(double x) {
        return Math.abs(arg.calculate(x));
    }

    @Override
    public Function dx() {
        return new Product(Sign.of(arg), arg.dx());
    }

    @Override
    public String toPrettyString(NumberFormat nf) {
        return String.format("|%s|", arg.toPrettyString(nf));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Abs abs = (Abs) o;
        return Objects.equals(arg, abs.arg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(arg);
    }
}
