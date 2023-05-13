package Function;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.StringJoiner;

public class Sum extends Composite {
    public Sum() {
        super();
    }
    public Sum(Function... functions) {
        super(functions);
    }
    public Sum(ArrayList<Function> functions) {
        super(functions);
    }

    @Override
    public double calculate(double x) {
        double calc = 0;
        for (Function function: getFunctions()) {
            calc += function.calculate(x);
        }
        return calc;
    }

    @Override
    public Function dx() {
        ArrayList<Function> f = new ArrayList<>(getFunctions().size());
        for (Function function: getFunctions()) {
            f.add(function.dx());
        }
        return new Sum(f);
    }

    @Override
    public String toPrettyString(NumberFormat nf) {
        final StringJoiner joiner = new StringJoiner("+");
        for (Function function : getFunctions()) {
            if (!function.equals(Const.NULL)) {
                joiner.add(function.toPrettyString(nf));
            }
        }
        return String.format("(%s)", joiner.toString()).replace("+-", "-");
    }
    public static Sum of(Function... terms) {
        return new Sum(terms);
    }
}
