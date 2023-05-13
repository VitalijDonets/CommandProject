package Function.test;

import Function.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.NumberFormat;

public class Sumtest {
    @Test
    public void testPr_cal52(){
        final double inputA = 5;
        final double inputB = 2;
        final double expectedresultcal = 7;
        final Function actualresult = Sum.of(Const.of(inputA), Const.of(inputB));
        Assertions.assertEquals(expectedresultcal,actualresult.calculate(inputA),1e-6);
    }
    @Test
    public void testPr_cal50(){
        final double inputA = 5;
        final double inputB = 0;
        final double expectedresultcal = 5;
        final Function actualresult = Sum.of(Const.of(inputA), Const.of(inputB));
        Assertions.assertEquals(expectedresultcal,actualresult.calculate(inputA));
    }
    @Test
    public void testPr_cal5_2(){
        final double inputA = 5;
        final double inputB = -2;
        final double expectedresultcal = 3;
        final Function actualresult = Sum.of(Const.of(inputA), Const.of(inputB));
        Assertions.assertEquals(expectedresultcal,actualresult.calculate(inputA));
    }
    @Test
    public void testPr_cal_52(){
        final double inputA = -5;
        final double inputB = 2;
        final double expectedresultcal = -3;
        final Function actualresult = Sum.of(Const.of(inputA), Const.of(inputB));
        Assertions.assertEquals(expectedresultcal,actualresult.calculate(inputA));
    }
    @Test
    public void testPr_cal_5_2(){
        final double inputA = -5;
        final double inputB = -2;
        final double expectedresultcal = -7;
        final Function actualresult = Sum.of(Const.of(inputA), Const.of(inputB));
        Assertions.assertEquals(expectedresultcal,actualresult.calculate(inputA));
    }
    @Test
    public void testPow_der(){
        final Function input = Linear.X;
        final Function inputB = Linear.X;

        final Function expectedresultcal = Sum.of(Const.of(1),Const.of(1));
        final Function actualresult= Sum.of(input,inputB);
        Assertions.assertEquals(expectedresultcal,actualresult.dx());
    }
    @Test
    public void testPr_tps(){
        final Function input =  Linear.X;
        final Function inputB =  Linear.X;
        final NumberFormat nf = NumberFormat.getInstance();
        final Function actualresult= Sum.of(input,inputB);
        Assertions.assertEquals(String.format("(x+x)"),String.format("%s", actualresult.toPrettyString(nf)));
    }
}
