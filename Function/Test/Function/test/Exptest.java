package Function.test;

import Function.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.NumberFormat;

public class Exptest {
    @Test
    public void testExp_cal(){
        final double input = -1;
        final double expectedresultcal = 0.367879;
        final Function actualresult = Exp.of(Const.of(input));
        Assertions.assertEquals(expectedresultcal,actualresult.calculate(input),1e-6);
    }
    @Test
    public void testExp_calzer(){
        final double input = 0;
        final double expectedresultcal = 1;
        final Function actualresult = Exp.of(Const.of(input));
        Assertions.assertEquals(expectedresultcal,actualresult.calculate(input));
    }
    @Test
    public void testExp_calpl(){
        final double input = 1;
        final double expectedresultcal = 2.718281;
        final Function actualresult = Exp.of(Const.of(input));
        Assertions.assertEquals(expectedresultcal,actualresult.calculate(input),1e-6);
    }
    @Test
    public void testExp_der(){
        final Function input = Exp.of(Linear.X);

        final Function expectedresultcal = Product.of(new Exp(Linear.X), Const.of(1));
        final Function actualresult= input.dx();
        Assertions.assertEquals(expectedresultcal,actualresult);
    }
    @Test
    public void testExp_tps(){
        final NumberFormat nf = NumberFormat.getInstance();
        final Function actualresult= Exp.of(Linear.X);
        Assertions.assertEquals(String.format("e^(x)"),String.format("%s", actualresult.toPrettyString(nf)));
    }
}
