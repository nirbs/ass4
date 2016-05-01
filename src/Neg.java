import java.util.Map;

/**
 * The Neg class is in charge of the negative calculation with the suitable methods.
 * @author Matan Ben Noach Nir Ben Shalom
 * @version 1.0 1 May 2016
 */
public class Neg extends UnaryExpression implements Expression {

    /**
     * The constructor gets an expression that inherits the
     * UnaryExpression methods.
     * @param e is an expression given by the user.
     */
    public Neg(Expression e) {
        super(e);
    }

    /**
     * The constructor gets a var that inherits the
     * UnaryExpression methods.
     * @param s is a string given by the user.
     */
    public Neg(String s) {
        super(new Var(s));
    }

    /**
     * The constructor gets a num that inherits the
     * UnaryExpression methods.
     * @param n is a double variable given by the user.
     */
    public Neg(double n) {
        super(new Num(n));
    }

    /**
     * Evaluate is in charge of evaluating the negative of
     * the expression by a map variable given by the user
     * @param assignment is a map that holds a variable and its value
     * @return the negative of the expression
     * @throws Exception in case the expression does'nt exist
     */
    public double evaluate(Map<String, Double> assignment) throws Exception {
        try {
            return super.getE1().evaluate(assignment) * (-1);
        } catch (Exception e) {
            System.out.println("No such expression!");
            throw e;
        }
    }

    /**
     * Evaluate is in charge of evaluating the negative of
     * the expression
     * @return the negative of the expression
     * @throws Exception in case the expression does'nt exist
     */
    public double evaluate() throws Exception {
        try {
            return super.getE1().evaluate() * (-1);
        } catch (Exception e) {
            System.out.println("No such expression!");
            throw e;
        }
    }

    /**
     * toString returns the string representation of negative expression.
     * @return the string representation of negative expression.
     */
    public String toString() {
        return "(" + "-" + super.getE1().toString() + ")";
    }

    /**
     * assign is in charge of replacing a variable with an expression.
     * @param var is a given variable from the user
     * @param expression the expression to replace the variable
     * @return the new expression after the replacement
     */
    public Expression assign(String var, Expression expression) {
        return new Neg(super.getE1().assign(var, expression));
    }

    /**
     * differentiate Method returns the derivative of the expression according to the var given.
     * @param var the var we will differentiate by.
     * @return The derivative by var of the expression.
     */
    public Expression differentiate(String var) {
        return new Mult(-1, super.getE1().differentiate(var));
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
                return null;
            }
        }
        return new Neg(super.getE1().simplify());
    }
}

