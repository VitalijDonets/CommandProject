package Function;

import java.text.NumberFormat;

public class Sqrt implements Function {
    private final Function arg;

    public Sqrt(Function arg) {
        this.arg = arg;
    }
    public static Sqrt of(Function f){
        return new Sqrt(f);
    }

    @Override
    public double calculate(double x) {
        return Math.sqrt(arg.calculate(x));
    }

    @Override
    public Function dx() {
        return new Product(Pow.of(Product.of(Const.of(2), Sqrt.of(arg)), -1), arg.dx());
    }

    @Override
    public String toPrettyString(NumberFormat nf) {
        return String.format("sqrt(%s)", arg.toPrettyString(nf));
    }
}
