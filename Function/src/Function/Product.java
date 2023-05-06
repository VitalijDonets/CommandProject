package Function;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.StringJoiner;

public class Product extends Composite {
    public Product() {
        super();
    }

    public Product(Function... functions) {
        super(functions);
    }

    public Product(ArrayList<Function> functions) {
        super(functions);
    }
    public static Product of(Function... terms) {
        return new Product(terms);
    }
    @Override
    public double calculate(double x) {
        double calc = 1;
        for (Function function: getFunctions()) {
            calc *= function.calculate(x);
        }
        return calc;
    }

    @Override
    public Function dx() {
        ArrayList<Function> finalF = new ArrayList<>(getFunctions().size());
        for(int i = 0; i < getFunctions().size(); i++){
            ArrayList<Function> PrF = new ArrayList<>(getFunctions().size());
            int j = 0;
                for (Function function: getFunctions()) {
                    if(j == i) PrF.add(function.dx());
                    else PrF.add(function);
                    j++;
                }
            finalF.add(new Product(PrF));
        }
        return new Sum(finalF);
    }

    @Override
    public String toPrettyString(NumberFormat nf) {
        final StringJoiner joiner = new StringJoiner("*");
        for (Function function : getFunctions()) {
            if(!function.equals(Const.of(1.0)))
                joiner.add(function.toPrettyString(nf));
        }
        return String.format("(%s)", joiner.toString());
    }
}