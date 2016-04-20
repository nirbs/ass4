import java.util.List;
import java.util.Map;

/**
 * Created by Matan on 20/04/2016.
 */
public class ExpressionsTest {
    public static void main(String[] args) {
        Num num1 = new Num(3);
        Num num2 = new Num(7);
        Var var1 = new Var("x");
        Plus e1 = new Plus(num1, num2);
        Minus e2 = new Minus(e1, var1);
        System.out.println(e1);

        try {
            System.out.println("Sum = " + e1.evaluate());
        }
        catch (Exception c) {

        }

        List<String> vars = e2.getVariables();
        for (String v : vars) {
            System.out.println(v);
        }



        Expression e3 = e2.assign("x", e1);
        System.out.println(e3);

        try {
            System.out.println("Sum = " + e3.evaluate());
        }
        catch (Exception c) {

        }

    }
}
