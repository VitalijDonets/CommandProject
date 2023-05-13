package Function.test;

import Function.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.NumberFormat;

public class Sqrtest {
    @Test
    public void testSqrt_cal(){
        final double input = 9;
        final double expectedresultcal = 3;
        final Function actualresult = Sqrt.of(Const.of(input));
        Assertions.assertEquals(expectedresultcal,actualresult.calculate(input));
    }
    @Test
    public void testSqrt_calzer(){
        final double input = 0;
        final double expectedresultcal = 0;
        final Function actualresult = Sqrt.of(Const.of(input));
        Assertions.assertEquals(expectedresultcal,actualresult.calculate(input));
    }
    @Test
    public void testSqrt_der(){
        final Function input = Linear.X;

        final Function expectedresultcal = Product.of(Pow.of(Product.of(Const.of(2), Sqrt.of(input)), -1), Const.of(1));
        final Function actualresult= Sqrt.of(Linear.X);
        Assertions.assertEquals(expectedresultcal,actualresult.dx());
    }
    @Test
    public void testSqrt_tps(){
        final Function input = Linear.X;
        final NumberFormat nf = NumberFormat.getInstance();
        final Function actualresult= Sqrt.of(Linear.X);
        Assertions.assertEquals(String.format("sqrt(x)"),String.format("%s", actualresult.toPrettyString(nf)));
    }
}
