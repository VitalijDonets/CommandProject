package Function.test;

import Function.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.NumberFormat;

public class Signtest {
    @Test
    public void testSign_cal(){
        final double input = -10;
        final double expectedresultcal = -1;
        final Function actualresult = Sign.of(Const.of(input));
        Assertions.assertEquals(expectedresultcal,actualresult.calculate(input));
    }
    @Test
    public void testSign_calzer(){
        final double input = 0;
        final double expectedresultcal = 0;
        final Function actualresult = Sign.of(Const.of(input));
        Assertions.assertEquals(expectedresultcal,actualresult.calculate(input));
    }
    @Test
    public void testSign_calpl(){
        final double input = 10;
        final double expectedresultcal = 1;
        final Function actualresult = Sign.of(Const.of(input));
        Assertions.assertEquals(expectedresultcal,actualresult.calculate(input));
    }
    @Test
    public void testSign_der(){
        final Function input = Linear.X;

        final Function expectedresultcal = Const.NULL;
        final Function actualresult= Sign.of(Linear.X);
        Assertions.assertEquals(expectedresultcal,actualresult.dx());
    }
    @Test
    public void testSign_tps(){
        final Function input = Linear.X;
        final NumberFormat nf = NumberFormat.getInstance();
        final Function actualresult= Sign.of(Linear.X);
        Assertions.assertEquals(String.format("sign(x)"),String.format("%s", actualresult.toPrettyString(nf)));
    }
}
