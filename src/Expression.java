/**
 * Created by user on 13/04/2016.
 */

import java.util.Map;
import java.util.List;

public interface Expression {
    /**
     * evaluate Method calculates the value of the expression according to the map it gets.
     * @param assignment the map for the values of the variables.
     * @return the result of the Expression.
     * @throws Exception in case an invalid Expression was received.
     */
    // Evaluate the expression using the variable values provided
    // in the assignment, and return the result.  If the expression
    // contains a variable which is not in the assignment, an exception
    // is thrown.
    double evaluate(Map<String, Double> assignment) throws Exception;

    /**
     * evaluate method calculates the value of the Expression.
     * @return the result of the Expression.
     * @throws Exception in case an invalid Expression was received.
     */
    // A convenience method. Like the `evaluate(assignment)` method above,
    // but uses an empty assignment.
    double evaluate() throws Exception;

    // Returns a list of the variables in the expression.
    List<String> getVariables();

    /**
     * toString method returns the Expression in string the right string format.
     * @return the right string format of the expression.
     */
    // Returns a nice string representation of the expression.
    String toString();

    /**
     * assign Method finds the var wanted and replaces it with a new expression.
     * @param var the name of the var we want to replace.
     * @param expression the Expression we want to replace the Var with.
     * @return The new Expression with the Var replaced with the Expression.
     */
    // Returns a new expression in which all occurrences of the variable
    // var are replaced with the provided expression (Does not modify the
    // current expression).
    Expression assign(String var, Expression expression);
}
