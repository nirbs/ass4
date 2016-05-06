import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * The Const class contains a constant variable which will have a name and a value.
 *
 * @author Matan Ben Noach Nir Ben Shalom
 * @version 1.0 1 May 2016
 */
public class Const implements Expression {
    private String name; // The name of the const
    private double value; // The value of the const.

    /**
     * Const constructor.
     *
     * @param name  the name of the const.
     * @param value the value of the const.
     */
    public Const(String name, double value) {
        this.name = name;
        this.value = value;
    }

    /**
     * evaluate Method evaluates the Expression according to the map it gets.
     *
     * @param assignment the map for the values of the variables.
     * @return the result of the Expression.
     * @throws Exception in case an invalid Expression was received.
     */
    public double evaluate(Map<String, Double> assignment) throws Exception {
        try {
            return this.value;
        } catch (Exception e) {
            System.out.println("Can't evaluate");
            throw e;
        }
    }

    /**
     * evaluate Method evaluates the Expression.
     *
     * @return the result of the Expression.
     * @throws Exception in case an invalid Expression was received.
     */
    public double evaluate() throws Exception {
        try {
            return this.value;
        } catch (Exception e) {
            System.out.println("Can't evaluate");
            throw e;
        }
    }

    /**
     * toString method returns the Expression in string the right string format.
     *
     * @return the right string format of the expression.
     */
    public String toString() {
        return name;
    }

    /**
     * getVariables method an empty list because there is no variables in a Const Expression.
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
        return new Const(this.name, this.value);
    }
}
