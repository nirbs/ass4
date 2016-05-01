import java.util.Map;

/**
 * Created by user on 20/04/2016.
 */

/**
 * The Sin class is in charge of the sine calculation with the suitable methods.
 */
public class Sin extends UnaryExpression implements Expression {

    /**
     * The constructor gets an expression that inherits the
     * UnaryExpression methods.
     * @param e is an expression given by the user.
     */
    public Sin(Expression e) {
        super(e);
    }

    /**
     * The constructor gets a var that inherits the
     * UnaryExpression methods.
     * @param s is a string given by the user.
     */
    public Sin(String s) {
        super(new Var(s));
    }

    /**
     * The constructor gets a num that inherits the
     * UnaryExpression methods.
     * @param n is a double variable given by the user.
     */
    public Sin(double n) {
        super(new Num(n));
    }

    /**
     * Evaluate is in charge of evaluating the sine of
     * the expression by a map variable given by the user
     * @param assignment is a map that holds a variable and its value
     * @return the sine of the expression
     * @throws Exception in case the expression does'nt exist
     */
    public double evaluate(Map<String, Double> assignment) throws Exception {
        try {
            return Math.sin(super.getE1().evaluate(assignment));
        } catch (Exception e) {
            System.out.println("No such expression!");
            throw e;
        }
    }

    /**
     * Evaluate is in charge of evaluating the sine of
     * the expression
     * @return the sine of the expression
     * @throws Exception in case the expression does'nt exist
     */
    public double evaluate() throws Exception {
        try {
            return Math.sin(super.getE1().evaluate());
        } catch (Exception e) {
            System.out.println("No such expression!");
            throw e;
        }
    }

    /**
     * toString returns the string representation of sine expression.
     * @return the string representation of sine expression.
     */
    public String toString() {
        return "(" + "sin(" + super.getE1().toString() + "))";
    }

    /**
     * assign is in charge of replacing a variable with an expression.
     * @param var is a given variable from the user
     * @param expression the expression to replace the variable
     * @return the new expression after the replacement
     */
    public Expression assign(String var, Expression expression) {
        return new Sin(super.getE1().assign(var, expression));
    }

    /**
     * differentiate Method returns the derivative of the expression according to the var given.
     * @param var the var we will differentiate by.
     * @return The derivative by var of the expression.
     */
    public Expression differentiate(String var) {
        return new Mult(new Cos(super.getE1()), super.getE1().differentiate(var));
    }

    /**
     * simplify method simplifies the expression.
     * @return A simplified version on the expression.
     */
    public Expression simplify() {
        // Check if the Expression has no variables.
        if (getVariables().isEmpty()) {
            try {
                return new Num(evaluate());
            } catch (Exception e) {
            }
        }
        return new Sin(super.getE1().simplify());
    }
}
