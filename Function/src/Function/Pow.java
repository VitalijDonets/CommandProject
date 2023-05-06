package Function;

import java.text.NumberFormat;

public class Pow implements Function{
    private final Function base;
    private final double power;

    public Pow(Function base, double power) {
        this.base = base;
        this.power = power;
    }
    public static Pow of(Function base, double power) {
        return new Pow(base, power);
    }
    @Override
    public double calculate(double x) {
        return Math.pow(base.calculate(x), power);
    }

    @Override
    public Function dx() {
        return new Product(Const.of(power), Pow.of(base, power - 1), base.dx());
    }

    @Override
    public String toPrettyString(NumberFormat nf) {
        if(power != 1) return String.format("(%s)^(" + power + ")", base.toPrettyString(nf));
        else return String.format("(%s)", base.toPrettyString(nf));
    }
}
