
/**
 * The SimplificationDemo class is in charge of showing the advanced simplification.
 * @author Matan Ben Noach Nir Ben Shalom.
 * @version 1.0 1 May 2016.
 */
public class SimplificationDemo {
    /**
     * main method demonstrates our advanced simplification.
     * @param args input from command line.
     */
    public static void main(String[] args) {
        Expression e = new Pow(new Mult(new Plus("x", "y"), 3), 0);
        System.out.println(e);
        System.out.println(e.simplify());
        Expression ex = new Pow(new Pow("x",new Plus(5,3)),"z");
        System.out.println(ex);
        System.out.println(ex.simplify());
    }
}
