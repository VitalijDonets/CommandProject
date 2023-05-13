package Function;

import java.text.NumberFormat;
import java.util.Objects;

public class Linear implements Function{
    public static final Linear X = new Linear(1.0) {
        @Override
        public String toPrettyString(NumberFormat nf) {
            return "x";
        }
    };

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Linear linear = (Linear) o;
        return Double.compare(linear.coef, coef) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(coef);
    }

    private final double coef;

    public Linear(double coef) {
        this.coef = coef;
    }

    @Override
    public double calculate(double x) {
        return coef*x;
    }

    @Override
    public Function dx() {
        return new Const(coef);
    }

    @Override
    public String toPrettyString(NumberFormat nf) {
        return String.format("%s*x", nf.format(coef));
    }


    public static Linear of(double coef) {
        return new Linear(coef);
    }
}
