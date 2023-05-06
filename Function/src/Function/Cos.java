package Function;

import java.text.NumberFormat;

public class Cos implements Function{
    private final Function arg;

    public Cos(Function arg) {
        this.arg = arg;
    }
    public static Cos of(Function f){
        return new Cos(f);
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
