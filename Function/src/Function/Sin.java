package Function;

import java.text.NumberFormat;

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
    public Function dx() {
        return new Product(Cos.of(arg), arg.dx());
    }

    @Override
    public String toPrettyString(NumberFormat nf) {
        return String.format("sin(%s)", arg.toPrettyString(nf));
    }
}
