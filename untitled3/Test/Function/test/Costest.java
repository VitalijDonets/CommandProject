package Function.test;

import Function.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.NumberFormat;

public class Costest {
    @Test
    public void testCos_cal(){
        final double input = -1;
        final double expectedresultcal = 0.540302;
        final Function actualresult = Cos.of(Const.of(input));
        Assertions.assertEquals(expectedresultcal,actualresult.calculate(input),1e-6);
    }
    @Test
    public void testCos_calzer(){
        final double input = 0;
        final double expectedresultcal = 1;
        final Function actualresult = Cos.of(Const.of(input));
        Assertions.assertEquals(expectedresultcal,actualresult.calculate(input));
    }
    @Test
    public void testCos_calpl(){
        final double input = 1;
        final double expectedresultcal = 0.540302;
        final Function actualresult = Cos.of(Const.of(input));
        Assertions.assertEquals(expectedresultcal,actualresult.calculate(input),1e-6);
    }
    @Test
    public void testCos_der(){
        final Function input = Cos.of(Linear.X);

        final Function expectedresultcal = Product.of(Const.of(-1), Sin.of(Linear.X),Const.of(1));
        final Function actualresult= input;
        Assertions.assertEquals(expectedresultcal,actualresult.dx());
    }
    @Test
    public void testCos_tps(){
        final Function input =  Cos.of(Linear.X);
        final NumberFormat nf = NumberFormat.getInstance();
        final Function actualresult= input;
        Assertions.assertEquals(String.format("cos(x)"),String.format("%s", actualresult.toPrettyString(nf)));
    }
}

