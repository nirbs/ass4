import java.util.List;
import java.util.Map;

/**
 * Created by Matan on 20/04/2016.
 */
public class ExpressionsTest {
    static void main(String[] args) {
        Expression e1 = new Plus(new Num(3), new Num(7));
        System.out.println(e1);

        try {
            System.out.println("Sum = " + e1.evaluate());
        }
        catch (Exception c) {

        }

        List<String> vars = e1.getVariables();
        for (String v : vars) {
            System.out.println(v);
        }
    }
}
