package Function.test;

import Function.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.NumberFormat;

public class Lntest {
    @Test
    public void testLinear_calpl(){
        final double input = 1;
        final double expectedresultcal = 0;
        final Function actualresult = Ln.of(Const.of(input));
        Assertions.assertEquals(expectedresultcal,actualresult.calculate(input),1e-6);
    }
    @Test
    public void testLinear_der(){
        final Function expectedresultcal = Product.of(Pow.of(Linear.X, -1),Const.of(1));
        final Function actualresult = Ln.of(Linear.X);
        Assertions.assertEquals(expectedresultcal,actualresult.dx());
    }
    @Test
    public void testLinear_tps(){
        final NumberFormat nf = NumberFormat.getInstance();
        final Function actualresult=   Ln.of(Linear.X);
        Assertions.assertEquals(String.format("ln(x)"),String.format("%s", actualresult.toPrettyString(nf)));
    }
}
