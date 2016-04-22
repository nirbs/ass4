import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Matan on 20/04/2016.
 */
public class ExpressionsTest {
    public static void main(String[] args) {
        Plus e1 = new Plus(3, 7);
        Minus e2 = new Minus(e1, "x");
        System.out.println(e1);

        try {
            System.out.println("Sum = " + e1.evaluate());
        } catch (Exception c) {

        }

        List<String> vars = e2.getVariables();
        for (String v : vars) {
            System.out.println(v);
        }


        Expression e3 = new Log("z", 2);
        Expression e4 = new Mult(8, 4);
        System.out.println(e3);
        System.out.println(e4);
        Expression e6 = e3.assign("z", e4);

        Expression e5 = e2.assign("x", e6);
        System.out.println(e5);

        try {
            System.out.println("Sum = " + e5.evaluate());
        } catch (Exception c) {

        }

        Expression e7 = new Pow(e5, new Num(3));
        System.out.println(e7);

        try {
            System.out.println("Sum = " + e7.evaluate());
        } catch (Exception c) {

        }

        Expression e8 = new Div(e7, new Num(25));
        System.out.println(e8);
        try {
            System.out.println("Sum = " + e8.evaluate());
        } catch (Exception c) {

        }
        reverseTest();
        Expression e9 = new Log("v","w");

        System.out.println(e9);
        List<String> logVars = e9.getVariables();
        for (String v : logVars) {
            System.out.println(v);
        }
        urineTest();


        Expression pow = new Pow("x", 4);
        Expression dPow = pow.differentiate("x");
        System.out.println(dPow);

        Expression mult = new Mult(1,"x");
        Expression dx = mult.differentiate("x");
        System.out.println(dx);
        System.out.println(dx.simplify());

        Expression div = new Div(1,"x");
        Expression divX = div.differentiate("y");

        Expression plus = new Plus(4, "x");
        Expression plusX = plus.differentiate("y");

        Expression minus = new Minus(4, "x");
        Expression minusX = minus.differentiate("y");

        Expression log = new Log(5, "x");
        Expression logX = log.differentiate("y");

        Expression cos = new Cos("x");
        Expression cosX = cos.differentiate("y");

        Expression sin = new Sin("x");
        Expression sinX = sin.differentiate("y");

        Expression neg = new Neg("x");
        Expression negX = neg.differentiate("y");

        System.out.println(divX);
        System.out.println(plusX);
        System.out.println(minusX);
        System.out.println(logX);

        System.out.println(cosX);
        System.out.println(sinX);
        System.out.println(negX);

        Expression exp = new Mult(new Mult(1,"x"),new Mult(0,"x"));
        System.out.println("From here");
        System.out.println(exp.simplify());

        System.out.println(plusX.simplify());
        System.out.println(minusX.simplify());

        Expression xMinusX = new Minus("X","X");
        System.out.println(xMinusX.simplify());

        Expression divAAdiv = new Div(7,7);
        System.out.println(divAAdiv.simplify());

        Expression divAKamchan = new Div (7,1);
        Expression divNigmar = new Div (1,7);

        Expression divYYYY = new Div("y","y");

        Expression divY1 = new Div("y",1);

        Expression minusDiv = new Minus(5,5);

        Expression logDiv = new Log("x","x");
        Expression logNum = new Log(65,65);


        System.out.println(divAKamchan.simplify());
        System.out.println(divNigmar.simplify());
        System.out.println(divYYYY.simplify());
        System.out.println(divY1.simplify());
        System.out.println(minusDiv.simplify());
        System.out.println(dPow.simplify());
        System.out.println(logDiv.simplify());
        System.out.println(logNum.simplify());

        Expression cosinus = new Cos(0);
        Expression cosPlusinus = new Cos(new Plus(4, 5));

        Expression sinus = new Sin(0);
        Expression sinPlusinus = new Sin(new Plus(4, 5));
        System.out.println(cosinus.simplify());
        System.out.println(cosPlusinus.simplify());
        System.out.println(sinus.simplify());
        System.out.println(sinPlusinus.simplify());
    }

    public static void reverseTest() {
        Plus e1 = new Plus(7, 3);
        Minus e2 = new Minus(new Var("x"), e1);
        System.out.println(e1);

        try {
            System.out.println("Sum = " + e1.evaluate());
        } catch (Exception c) {

        }

        List<String> vars = e2.getVariables();
        for (String v : vars) {
            System.out.println(v);
        }


        Expression e3 = new Log(2, "z");
        Expression e4 = new Mult(4, 8);
        System.out.println(e3);
        System.out.println(e4);
        Expression e6 = e3.assign("z", e4);

        Expression e5 = e2.assign("x",e6);
        System.out.println(e5);

        try {
            System.out.println("Sum = " + e5.evaluate());
        } catch (Exception c) {

        }

        Expression e7 = new Pow(new Num(3), e5);
        System.out.println(e7);

        try {
            System.out.println("Sum = " + e7.evaluate());
        } catch (Exception c) {

        }

        Expression e8 = new Div(new Num(25), e7);
        System.out.println(e8);
        try {
            System.out.println("Sum = " + e8.evaluate());
        } catch (Exception c) {

        }
    }

    public static void urineTest() {
        Expression e1 = new Sin(new Num(2));
        System.out.println(e1);
        try {
            System.out.println("Sum = " + e1.evaluate());
        } catch (Exception c) {

        }
        Expression e2 = new Cos("x");
        System.out.println(e2);

        Map<String, Double> myMap = new TreeMap<String, Double>();
        myMap.put("x", Math.PI);
        try {
            System.out.println("Sum = " + e2.evaluate());
        } catch (Exception c) {

        }
        Expression e3 = new Plus (3,76);
        Expression e4 = e2.assign("x", e3);
        System.out.println(e4);
        try {
            System.out.println("Sum = " + e4.evaluate());
        } catch (Exception c) {

        }
        Expression e5 = e2.assign("x", new Neg(e3));
        System.out.println(e5);
        try {
            System.out.println("Sum = " + e5.evaluate());
        } catch (Exception c) {

        }





    }

}
