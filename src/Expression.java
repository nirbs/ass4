import java.util.List;
import java.util.Map;

/**
 * The Expression interface is an interface for mathematical expression.
 *
 * @author Matan Ben Noach Nir Ben Shalom
 * @version 1.0 1 May 2016
 */
public interface Expression {
    /**
     * evaluate Method calculates the value of the expression according to the map it gets.
     *
     * @param assignment the map for the values of the variables.
     * @return the result of the Expression.
     * @throws Exception in case an invalid Expression was received.
     */
    double evaluate(Map<String, Double> assignment) throws Exception;

    /**
     * evaluate method calculates the value of the Expression.
     *
     * @return the result of the Expression.
     * @throws Exception in case an invalid Expression was received.
     */
    double evaluate() throws Exception;

    /**
     * getVariables creates and returns a list with all of the
     * variables in every expression.
     *
     * @return a list with the variables in the expression.
     */
    List<String> getVariables();

    /**
     * toString method returns the Expression in string the right string format.
     *
     * @return the right string format of the expression.
     */
    String toString();

    /**
     * assign Method finds the var wanted and replaces it with a new expression.
     *
     * @param var        the name of the var we want to replace.
     * @param expression the Expression we want to replace the Var with.
     * @return The new Expression with the Var replaced with the Expression.
     */
    Expression assign(String var, Expression expression);

    /**
     * differentiate Method returns the derivative of the expression according to the var given.
     *
     * @param var the var we will differentiate by.
     * @return The derivative by var of the expression.
     */
    Expression differentiate(String var);

    /**
     * simplify method simplifies the expression.
     *
     * @return A simplified version on the expression.
     */
    Expression simplify();
}
