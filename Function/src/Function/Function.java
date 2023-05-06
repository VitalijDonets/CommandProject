package Function;

import java.text.NumberFormat;

public interface Function {
    double calculate(double x);
    Function dx();
    String toPrettyString(NumberFormat nf);
}
