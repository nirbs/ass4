import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * The Var class is a variable Expression.
 *
 * @author Matan Ben Noach Nir Ben Shalom.
 * @version 1.0 1 May 2016.
 */
public class Var implements Expression {
    private String var; // The name of the var.

    /**
     * Var constructor.
     *
     * @param var the name of the var.
     */
    public Var(String var) {
        this.var = var;
    }

    /**
     * evaluate method returns the value of the Var according to the map given.
     *
     * @param assignment the map for the values of variables.
     * @return the value of the Var according to the map.
     * @throws Exception in case an invalid Expression was received.
     */
    public double evaluate(Map<String, Double> assignment) throws Exception {
        try {
            return assignment.get(this.var);
        } catch (Exception e) {
            System.out.println("Can't evaluate");
            throw e;
        }
    }

    /**
     * evaluate method throws an exception because we cant evaluate a variable value without a map.
     *
     * @return nothing because we cant evaluate a variable without a map.
     * @throws Exception in case there is no map.
     */
    public double evaluate() throws Exception {
        throw new Exception("Can't evaluate varf without map");
    }

    /**
     * getVariables method returns a list with one name of a Var which is this Var.
     *
     * @return A list of strings which will include only this Var name.
     */
    public List<String> getVariables() {
        List l = new ArrayList<String>();
        l.add(this.var);
        return l;
    }

    /**
     * toString method returns the Expression in string the right string format.
     *
     * @return the right string format of the expression.
     */
    public String toString() {
        return this.var;
    }

    /**
     * assign Method checks if this is the Var were looking for and if so returns the Expression to replace it,
     * otherwise the method return this Var.
     *
     * @param myVar      the name of the var we want to replace.
     * @param expression the Expression we want to replace the Var with.
     * @return The new Expression with the Var replaced with the Expression if this is the Var were looking for,
     * otherwise the method this Var.
     */
    public Expression assign(String myVar, Expression expression) {
        if (myVar.equals(this.toString())) {
            return expression;
        }
        return new Var(this.var);
    }

    /**
     * differentiate Method returns the derivative of the expression according to the var given.
     *
     * @param myVar the var we will differentiate by.
     * @return The derivative by var of the expression.
     */
    public Expression differentiate(String myVar) {
        if (myVar.equals(this.toString())) {
            return new Num(1);
        }
        return new Num(0);
    }

    /**
     * simplify method simplifies the expression.
     *
     * @return A simplified version on the expression.
     */
    public Expression simplify() {
        return new Var(this.var);
    }

}