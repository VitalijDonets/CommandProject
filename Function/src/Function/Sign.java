package Function;

import java.text.NumberFormat;
import java.util.Objects;

public class Sign implements Function{
    private final Function arg;

    public Sign(Function arg) {
        this.arg = arg;
    }
    public static Sign of(Function f){
        return new Sign(f);
    }
    @Override
    public double calculate(double x) {
        return Math.signum(arg.calculate(x));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sign sign = (Sign) o;
        return Objects.equals(arg, sign.arg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(arg);
    }

    @Override
    public Function dx() {
        return Const.NULL;
    }

    @Override
    public String toPrettyString(NumberFormat nf) {
        return String.format("sign(%s)", arg.toPrettyString(nf));
    }
}
