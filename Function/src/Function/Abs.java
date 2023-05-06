package Function;

import java.text.NumberFormat;

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
}
