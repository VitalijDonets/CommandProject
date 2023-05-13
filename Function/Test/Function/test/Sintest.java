package Function.test;

import Function.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.NumberFormat;

public class Sintest {
    @Test
    public void testAbs_cal(){
        final double input = -1;
        final double expectedresultcal = -0.841471;
        final Function actualresult = Sin.of(Const.of(input));
        Assertions.assertEquals(expectedresultcal,actualresult.calculate(input),1e-6);
    }
    @Test
    public void testAbs_calzer(){
        final double input = 0;
        final double expectedresultcal = 0;
        final Function actualresult = Sin.of(Const.of(input));
        Assertions.assertEquals(expectedresultcal,actualresult.calculate(input),1e-6);
    }
    @Test
    public void testAbs_calpl(){
        final double input = 1;
        final double expectedresultcal = 0.841470;
        final Function actualresult = Sin.of(Const.of(input));
        Assertions.assertEquals(expectedresultcal,actualresult.calculate(input),1e-6);
    }
    @Test
    public void testAbs_der(){
        final Function expectedresultcal = Product.of(Cos.of(Linear.X),Const.of(1));
        final Function actualresult= Sin.of(Linear.X);
        Assertions.assertEquals(expectedresultcal,actualresult.dx());
    }
    @Test
    public void testAbs_tps(){
        final NumberFormat nf = NumberFormat.getInstance();
        final Function actualresult= Sin.of(Linear.X);
        Assertions.assertEquals(String.format("sin(x)"),String.format("%s", actualresult.toPrettyString(nf)));
    }
}
