package Function.test;

import Function.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.NumberFormat;

public class Abstest {
    @Test
    public void testAbs_cal(){
        final double input = -1;
        final double expectedresultcal = 1;
        final Function actualresult = Abs.of(Const.of(input));
        Assertions.assertEquals(expectedresultcal,actualresult.calculate(input));
    }
    @Test
    public void testAbs_calzer(){
        final double input = 0;
        final double expectedresultcal = 0;
        final Function actualresult = Abs.of(Const.of(input));
        Assertions.assertEquals(expectedresultcal,actualresult.calculate(input));
    }
    @Test
    public void testAbs_calpl(){
        final double input = 1;
        final double expectedresultcal = 1;
        final Function actualresult = Abs.of(Const.of(input));
        Assertions.assertEquals(expectedresultcal,actualresult.calculate(input));
    }
    @Test
    public void testAbs_der(){
        final Function expectedresultcal = Product.of(Sign.of(Linear.X),Const.of(1));
        final Function actualresult= Abs.of(Linear.X);
        Assertions.assertEquals(expectedresultcal,actualresult.dx());
    }
    @Test
    public void testAbs_tps(){
        final NumberFormat nf = NumberFormat.getInstance();
        final Function actualresult= Abs.of(Linear.X);
        Assertions.assertEquals(String.format("|x|"),String.format("%s", actualresult.toPrettyString(nf)));
    }

}
