package Function;

import java.text.NumberFormat;

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
    public Function dx() {
        return Const.NULL;
    }

    @Override
    public String toPrettyString(NumberFormat nf) {
        return String.format("sign(%s)", arg.toPrettyString(nf));
    }
}
