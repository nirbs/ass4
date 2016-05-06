import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws Exception {

         int p1 = ExpressionsTestPart1.main1();
         int p2 = ExpressionsTestPart2.main2();
         int p3 = ExpressionsTestPart3.main3();
         System.out.println("grades :" + p1 + "," + p2 + "," + p3 +" from 64");
         System.out.println("Final grade :" + (p1 +  p2 + p3) +" from 64");

        Expression h = new Sin(new Sin(new Pow("x", new Mult("y", "x"))));

        List<String> vars = h.getVariables();
        for (String s : vars) {
            System.out.println(s);

        }

        h = new Cos(new Sin(new Neg(new Plus("x", new Mult("y", new Minus("x", "z"))))));

        vars = h.getVariables();
        for (String s : vars) {
            System.out.println(s);
        }

        h = new Log(2, 8);
        System.out.println(h.evaluate());

        h = new Mult(new Log(2, new Plus(new Mult("x", 5), 8)), 10);
        System.out.println(h);
        System.out.println(h.simplify());
        Map<String, Double> myMap = new TreeMap<String, Double>();
        myMap.put("x", 24.0);
        System.out.println(h.evaluate(myMap));
        vars = h.getVariables();
        for (String s : vars) {
            System.out.println(s);
        }





    }
}