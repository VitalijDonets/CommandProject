package Function.test;

import Function.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.NumberFormat;

public class Lineartest {
    @Test
    public void testLinear_cal(){
        final double input = -1;
        final double expectedresultcal = -1;
        final Function actualresult = Linear.X;
        Assertions.assertEquals(expectedresultcal,actualresult.calculate(input),1e-6);
    }
    @Test
    public void testLinear_calzer(){
        final double input = 0;
        final double expectedresultcal = 0;
        final Function actualresult = Linear.X;
        Assertions.assertEquals(expectedresultcal,actualresult.calculate(input));
    }
    @Test
    public void testLinear_calpl(){
        final double input = 1;
        final double expectedresultcal = 1;
        final Function actualresult = Linear.X;
        Assertions.assertEquals(expectedresultcal,actualresult.calculate(input),1e-6);
    }
    @Test
    public void testLinear_der(){
        final Function input = Linear.X;

        final Function expectedresultcal = Const.of(1);
        final Function actualresult= input;
        Assertions.assertEquals(expectedresultcal,actualresult.dx());
    }
    @Test
    public void testLinear_tps(){
        final Function input =  Linear.X;
        final NumberFormat nf = NumberFormat.getInstance();
        final Function actualresult= input;
        Assertions.assertEquals(String.format("x"),String.format("%s", actualresult.toPrettyString(nf)));
    }
}
