import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * The Num class is a number Expression.
 *
 * @author Matan Ben Noach Nir Ben Shalom.
 * @version 1.0 1 May 2016.
 */
public class Num implements Expression {
    private double num; // The value of the Num

    /**
     * Num constructor.
     *
     * @param num the value of the Num.
     */
    public Num(double num) {
        this.num = num;
    }

    /**
     * toString method returns the Expression in string the right string format.
     *
     * @return the right string format of the expression.
     */
    public String toString() {
        return Double.toString(this.num);
    }

    /**
     * evaluate method returns the value of the Num according to the map given.
     *
     * @param assignment the map for the values of variables.
     * @return the value of the Num according to the map.
     * @throws Exception in case an invalid Expression was received.
     */
    public double evaluate(Map<String, Double> assignment) throws Exception {
        try {
            return this.num;
        } catch (Exception e) {
            System.out.println("Can't evaluate");
            throw e;
        }
    }

    /**
     * evaluate method returns the value of the Num.
     *
     * @return the value of the Num.
     * @throws Exception in case an invalid Expression was received.
     */
    public double evaluate() throws Exception {
        try {
            return this.num;
        } catch (Exception e) {
            System.out.println("Cant evaluate!");
            throw e;
        }
    }


    /**
     * getVariables method an empty list because there is no variables in a Num Expression.
     *
     * @return An empty list of strings.
     */
    public List<String> getVariables() {
        List l = new ArrayList<String>();
        return l;
    }

    /**
     * assign Method returns this Num because Num is not a variable so we cant assign it.
     *
     * @param var        the name of the var we want to replace.
     * @param expression the Expression we want to replace the Var with.
     * @return This num.
     */
    public Expression assign(String var, Expression expression) {
        return this;
    }

    /**
     * differentiate method returns the derivative of the expression according to the var given.
     *
     * @param var the var we will differentiate by.
     * @return The derivative by var of the expression.
     */
    public Expression differentiate(String var) {
        return new Num(0);
    }

    /**
     * simplify method simplifies the expression.
     *
     * @return A simplified version on the expression.
     */
    public Expression simplify() {
        return new Num(this.num);
    }
}
