import java.util.ArrayList;
import java.util.List;

/**
 * Created by Matan on 5/1/2016.
 */
public class SimplificationDemo {
    public static void main(String[] args) {
        Expression e = new Pow(new Mult(new Plus("x", "y"), 3), 0);
        System.out.println(e);
        System.out.println(e.simplify());
        Expression ex = new Pow(new Pow("x",new Plus("y",3)),"z");
        System.out.println(ex);
        System.out.println(ex.simplify());
        Expression multPlus = new Plus(new Mult(2,"x"),new Mult(4,"x"));
    }
}
