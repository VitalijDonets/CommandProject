package Function.test;

import Function.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.NumberFormat;

public class Consttest {
    @Test
    public void testConst_cal(){
        final double input = -1;
        final double expectedresultcal = -1;
        final Function actualresult = Const.of(input);
        Assertions.assertEquals(expectedresultcal,actualresult.calculate(input));
    }
    @Test
    public void testConst_calzer(){
        final double input = 0;
        final double expectedresultcal = 0;
        final Function actualresult = Const.of(input);
        Assertions.assertEquals(expectedresultcal,actualresult.calculate(input));
    }
    @Test
    public void testConst_calpl(){
        final double input = 1;
        final double expectedresultcal = 1;
        final Function actualresult = Const.of(input);
        Assertions.assertEquals(expectedresultcal,actualresult.calculate(input));
    }
    @Test
    public void testConst_der(){
        final Function input = Const.of(10);
        final Function expectedresultcal = Const.NULL;
        final Function actualresult = input.dx();
        Assertions.assertEquals(expectedresultcal,actualresult);
    }
    @Test
    public void testConst_tps(){
        final NumberFormat nf = NumberFormat.getInstance();
        final Function actualresult = Const.of(10);
        Assertions.assertEquals(String.format("10"),String.format("%s", actualresult.toPrettyString(nf)));
    }
}
