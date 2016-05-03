import java.util.Map;

/**
 * The Cos class is in charge of the cosine calculation with the suitable methods.
 * @author Matan Ben Noach Nir Ben Shalom
 * @version 1.0 1 May 2016
 */
public class Cos extends UnaryExpression implements Expression {
    /**
     * The constructor gets an expression that inherits the
     * UnaryExpression methods.
     * @param e is an expression given by the user.
     */
    public Cos(Expression e) {
        super(e);
    }

    /**
     * The constructor gets a var that inherits the
     * UnaryExpression methods.
     * @param s is a string given by the user.
     */
    public Cos(String s) {
        super(new Var(s));
    }

    /**
     * The constructor gets a num that inherits the
     * UnaryExpression methods.
     * @param n is a double variable given by the user.
     */
    public Cos(double n) {
        super(new Num(n));
    }

    /**
     * Evaluate is in charge of evaluating the cosine of
     * the expression by a map variable given by the user.
     * @param assignment is a map that holds a variable and its value.
     * @return the cosine of the expression.
     * @throws Exception in case the expression does'nt exist.
     */
    public double evaluate(Map<String, Double> assignment) throws Exception {
        try {
            return Math.cos(super.getE1().evaluate(assignment));
        } catch (Exception e) {
            System.out.println("No such expression!");
            throw e;
        }
    }

    /**
     * Evaluate is in charge of evaluating the cosine of
     * the expression.
     * @return the cosine of the expression.
     * @throws Exception in case the expression does'nt exist.
     */
    public double evaluate() throws Exception {
        try {
            return Math.cos(super.getE1().evaluate());
        } catch (Exception e) {
            System.out.println("No such expression!");
            throw e;
        }
    }

    /**
     * toString returns the string representation of cosine expression.
     * @return the string representation of cosine expression.
     */
    public String toString() {
        return "cos(" + super.getE1().toString() + ")";
    }

    /**
     * assign is in charge of replacing a variable with an expression.
     * @param var is a given variable from the user.
     * @param expression the expression to replace the variable.
     * @return the new expression after the replacement.
     */
    public Expression assign(String var, Expression expression) {
        return new Cos(super.getE1().assign(var, expression));
    }

    /**
     * differentiate Method returns the derivative of the expression according to the var given.
     * @param var the var we will differentiate by.
     * @return The derivative by var of the expression.
     */
    public Expression differentiate(String var) {
        return new Neg(new Mult(super.getE1().differentiate(var), new Sin(super.getE1())));
    }

    /**
     * simplify method simplifies the expression.
     * @return A simplified version on the expression.
     */
    public Expression simplify() {
        Expression exp = super.getE1().simplify();
        if (exp.getVariables().isEmpty()) {
            try {
                new Num(exp.evaluate());
            } catch (Exception e) {

            }
        }
        return new Cos(exp);
    }
}

