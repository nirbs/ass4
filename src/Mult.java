import java.util.Map;

/**
 * The Mult class creates a Multiply Expression between two different Expressions.
 *
 * @author Matan Ben Noach Nir Ben Shalom
 * @version 1.0 1 May 2016
 */
public class Mult extends BinaryExpression implements Expression {

    /**
     * Mult constructor.
     *
     * @param e1 the first Expression.
     * @param e2 the second Expression
     */
    public Mult(Expression e1, Expression e2) {
        super(e1, e2);
    }

    /**
     * Mult constructor.
     *
     * @param e the first Expression.
     * @param n the value of the second Expression which will be a Num Expression.
     */
    public Mult(Expression e, double n) {
        super(e, new Num(n));
    }

    /**
     * Mult constructor.
     *
     * @param e the first Expression.
     * @param s the name of the var of the second Expression which will be a Var Expression
     */
    public Mult(Expression e, String s) {
        super(e, new Var(s));
    }

    /**
     * Mult constructor.
     *
     * @param n the value of the first Expression which will be a Num Expression.
     * @param e the second Expression.
     */
    public Mult(double n, Expression e) {
        super(new Num(n), e);
    }

    /**
     * Mult constructor.
     *
     * @param s the name of the var of the first Expression which will be a Var Expression
     * @param e the second Expression
     */
    public Mult(String s, Expression e) {
        super(new Var(s), e);
    }

    /**
     * Mult constructor.
     *
     * @param v the name of the var of the first Expression which will be a Var Expression
     * @param n the value of the second Expression which will be a Num Expression.
     */
    public Mult(String v, double n) {
        super((new Var(v)), new Num(n));
    }

    /**
     * Mult constructor.
     *
     * @param n the value of the second Expression which will be a Num Expression.
     * @param v the name of the var of the first Expression which will be a Var Expression
     */
    public Mult(double n, String v) {
        super(new Num(n), (new Var(v)));
    }

    /**
     * Mult constructor.
     *
     * @param s1 the name of the var of the first Expression which will be a Var Expression
     * @param s2 the name of the var of the second Expression which will be a Var Expression
     */
    public Mult(String s1, String s2) {
        super((new Var(s1)), new Var(s2));
    }

    /**
     * Mult constructor.
     *
     * @param n1 the value of the first Expression which will be a Num Expression.
     * @param n2 the value of the second Expression which will be a Num Expression.
     */
    public Mult(double n1, double n2) {
        super((new Num(n1)), new Num(n2));
    }

    /**
     * evaluate Method multiplies the two expression according to the map it gets.
     *
     * @param assignment the map for the values of the variables.
     * @return the result of the multiplication between the two Expression.
     * @throws Exception in case an invalid Expression was received.
     */
    public double evaluate(Map<String, Double> assignment) throws Exception {
        try {
            return super.getE1().evaluate(assignment) * super.getE2().evaluate(assignment);
        } catch (Exception e) {
            System.out.println("Can't evaluate");
            throw e;
        }
    }

    /**
     * evaluate Method multiplies the two expression.
     *
     * @return the result of the multiplication between the two Expression.
     * @throws Exception in case an invalid Expression was received.
     */
    public double evaluate() throws Exception {
        try {
            return super.getE1().evaluate() * super.getE2().evaluate();
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
        return "(" + super.getE1().toString() + " * " + super.getE2().toString() + ")";
    }

    /**
     * assign Method finds the var wanted and replaces it with a new expression.
     *
     * @param var        the name of the var we want to replace.
     * @param expression the Expression we want to replace the Var with.
     * @return The new Expression with the Var replaced with the Expression.
     */
    public Expression assign(String var, Expression expression) {
        return new Mult(super.getE1().assign(var, expression), super.getE2().assign(var, expression));
    }

    /**
     * differentiate Method returns the derivative of the expression according to the var given.
     *
     * @param var the var we will differentiate by.
     * @return The derivative by var of the expression.
     */
    public Expression differentiate(String var) {
        return new Plus(new Mult(super.getE1().differentiate(var), super.getE2()),
                new Mult(super.getE1(), super.getE2().differentiate(var)));
    }

    /**
     * simplify method simplifies the expression.
     *
     * @return A simplified version on the expression.
     */
    public Expression simplify() {
        Expression exp1 = super.getE1().simplify();
        Expression exp2 = super.getE2().simplify();
        try {
            if (exp1.getVariables().isEmpty() && exp2.getVariables().isEmpty()) {
                return new Num(exp1.evaluate() * exp2.evaluate());
            }
            if (exp1.getVariables().isEmpty()) {
                double res = exp1.evaluate();
                // Check if exp1 equals 1.
                if (Math.abs(res - 1.0) < 0.00001) {
                    return exp2;
                } else if (Math.abs(res) < 0.00001) { // Check if exp1 equals 0.
                    return new Num(0);
                }
                return new Mult(new Num(res), exp2);
            }
            if (exp2.getVariables().isEmpty()) {
                double res = exp2.evaluate();
                // Check if exp2 equals 1.
                if (Math.abs(res - 1.0) < 0.00001) {
                    return exp1.simplify();
                } else if (Math.abs(res) < 0.00001) { // Check if exp2 equals 0.
                    return new Num(0);
                }
                return new Mult(exp1, new Num(res));
            }
        } catch (Exception e) {
            return null;
        }
        return new Mult(exp1, exp2);
    }

}
