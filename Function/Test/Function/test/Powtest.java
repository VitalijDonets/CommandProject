package Function.test;

import Function.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.NumberFormat;

public class Powtest {
    @Test
    public void testPow_cal52(){
        final double inputA = 5;
        final double inputB = 2;
        final double expectedresultcal = 25;
        final Function actualresult = Pow.of(Const.of(inputA),inputB);
        Assertions.assertEquals(expectedresultcal,actualresult.calculate(inputA),1e-6);
    }
    @Test
    public void testPow_cal50(){
        final double inputA = 5;
        final double inputB = 0;
        final double expectedresultcal = 1;
        final Function actualresult = Pow.of(Const.of(inputA),inputB);
        Assertions.assertEquals(expectedresultcal,actualresult.calculate(inputA));
    }
    @Test
    public void testPow_cal5_2(){
        final double inputA = 5;
        final double inputB = -2;
        final double expectedresultcal = 0.04;
        final Function actualresult = Pow.of(Const.of(inputA),inputB);
        Assertions.assertEquals(expectedresultcal,actualresult.calculate(inputA));
    }
    @Test
    public void testPow_cal_52(){
        final double inputA = -5;
        final double inputB = 2;
        final double expectedresultcal = 25;
        final Function actualresult = Pow.of(Const.of(inputA),inputB);
        Assertions.assertEquals(expectedresultcal,actualresult.calculate(inputA));
    }
    @Test
    public void testPow_cal_5_2(){
        final double inputA = -5;
        final double inputB = -2;
        final double expectedresultcal = 0.04;
        final Function actualresult = Pow.of(Const.of(inputA),inputB);
        Assertions.assertEquals(expectedresultcal,actualresult.calculate(inputA));
    }
    @Test
    public void testPow_der(){
        final Function input = Linear.X;
        final double inputB = 2;
        final Function expectedresultcal = Product.of(Const.of(inputB), Pow.of(input, inputB - 1),Const.of(1));
        final Function actualresult= Pow.of(input,inputB);
        Assertions.assertEquals(expectedresultcal,actualresult.dx());
    }
    @Test
    public void testPow_tps(){
        final Function input = Linear.X;
        final double inputB = 2;
        final NumberFormat nf = NumberFormat.getInstance();
        final Function actualresult= Pow.of(input,inputB);
        Assertions.assertEquals(String.format("(x)^(2.0)"),String.format("%s", actualresult.toPrettyString(nf)));
    }
}
