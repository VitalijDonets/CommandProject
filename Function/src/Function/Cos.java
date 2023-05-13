package Function;

import java.text.NumberFormat;
import java.util.Objects;

public class Cos implements Function{
    private final Function arg;

    public Cos(Function arg) {
        this.arg = arg;
    }
    public static Cos of(Function f){
        return new Cos(f);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cos cos = (Cos) o;
        return Objects.equals(arg, cos.arg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(arg);
    }

    @Override
    public double calculate(double x) {
        return Math.cos(arg.calculate(x));
    }

    @Override
    public Function dx() {
        return new Product(Const.of(-1), Sin.of(arg), arg.dx());
    }

    @Override
    public String toPrettyString(NumberFormat nf) {
        return String.format("cos(%s)", arg.toPrettyString(nf));
    }
}
