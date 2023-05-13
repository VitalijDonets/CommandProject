import Function.*;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    private static double a = -2;
    private static double b = 3;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введіть x0: ");
        double x = scan.nextDouble();
        final Function f1 = Sum.of(
                Exp.of(Product.of(
                        Const.of(a),
                        Pow.of(Cos.of(Linear.X), 2))
                ),
                Product.of(Const.of(-1),
                        Abs.of(Product.of(
                                Const.of(b),
                                Pow.of(Ln.of(Sqrt.of(Linear.X)), 5))
                        )
                )
        );
        final Function g1 = f1.dx();
        final NumberFormat nf = NumberFormat.getInstance();
        System.out.format("f1(x) = %s", f1.toPrettyString(nf)).println();
        System.out.println("f1(" + x + ") = " + f1.calculate(x));
        System.out.println("st f1(" + x + ") = " +
                (Math.exp(a*Math.pow(Math.cos(x), 2)) - Math.abs(b * Math.pow(Math.log(Math.sqrt(x)), 5))));
        System.out.format("f1'(x)= %s", g1.toPrettyString(nf)).println();
        System.out.println("f1'(" + x + ") = " + g1.calculate(x));

        final Function f2 = Product.of(
                Product.of(Const.of(a), Pow.of(Linear.X, 3)),
                Pow.of(Sin.of(Sum.of(Linear.X, Const.of(b))), -2)
        );
        final Function g2 = f2.dx();
        System.out.format("f2(x) = %s", f2.toPrettyString(nf)).println();
        System.out.println("f2(" + x + ") = " + f2.calculate(x));
        System.out.println("st f2(" + x + ") = " +
                (a * Math.pow(x, 3)) / (Math.pow(Math.sin(x + b), 2)));
        System.out.format("f2'(x)= %s", g2.toPrettyString(nf)).println();
        System.out.println("f2(" + x + ") = " + g2.calculate(x));
    }
}