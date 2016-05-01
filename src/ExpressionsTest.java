import java.util.Map;
import java.util.TreeMap;

/**
 * The ExpressionTest class is in charge of testing the code.
 * @author Matan Ben Noach Nir Ben Shalom.
 * @version 1.0 1 May 2016.
 */
public class ExpressionsTest {
    /**
     * main method tests our classes and prints the results.
     * @param args input from command line.
     */
    public static void main(String[] args) {
        Expression e = new Plus(new Mult(2, "x"), new Plus(new Sin(new Mult(4, "y")),
                new Pow(new Const("e", 2.71), "x")));
        System.out.println(e);
        Map<String, Double> myMap = new TreeMap<String, Double>();
        myMap.put("x", 2.0);
        myMap.put("y", 0.25);
        myMap.put("e", 2.71);
        myMap.put("0.0", 0.0);
        myMap.put("1.0", 1.0);
        myMap.put("2.0", 2.0);
        myMap.put("4.0", 4.0);
        try {
            System.out.println(e.evaluate(myMap));
        } catch (Exception ex) {
            ex.getMessage();
        }
        Expression de = e.differentiate("x");
        System.out.println(de);
        try {
            System.out.println(de.evaluate(myMap));
        } catch (Exception ex) {
            ex.getMessage();
        }
        System.out.println(de.simplify());
    }

}
