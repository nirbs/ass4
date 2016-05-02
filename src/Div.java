import java.util.Map;

/**
 * The Div class creates a division Expression between two different Expressions.
 * @author Matan Ben Noach Nir Ben Shalom
 * @version 1.0 1 May 2016
 */
public class Div extends BinaryExpression implements Expression {
    /**
     * Div constructor.
     * @param e1 the first Expression.
     * @param e2 the second Expression
     */
    public Div(Expression e1, Expression e2) {
        super(e1, e2);
    }

    /**
     * Div constructor.
     * @param e the first Expression.
     * @param n the value of the second Expression which will be a Num Expression.
     */
    public Div(Expression e, double n) {
        super(e, new Num(n));
    }

    /**
     * Div constructor.
     * @param e the first Expression.
     * @param s the name of the var of the second Expression which will be a Var Expression
     */
    public Div(Expression e, String s) {
        super(e, new Var(s));
    }

    /**
     * Div constructor.
     * @param n the value of the first Expression which will be a Num Expression.
     * @param e the second Expression.
     */
    public Div(double n, Expression e) {
        super(new Num(n), e);
    }

    /**
     * Div constructor.
     * @param s the name of the var of the first Expression which will be a Var Expression
     * @param e the second Expression
     */
    public Div(String s, Expression e) {
        super(new Var(s), e);
    }

    /**
     * Div constructor.
     * @param v the name of the var of the first Expression which will be a Var Expression
     * @param n the value of the second Expression which will be a Num Expression.
     */
    public Div(String v, double n) {
        super((new Var(v)), new Num(n));
    }

    /**
     * Div constructor.
     * @param n the value of the second Expression which will be a Num Expression.
     * @param v the name of the var of the first Expression which will be a Var Expression
     */
    public Div(double n, String v) {
        super(new Num(n), (new Var(v)));
    }

    /**
     * Div constructor.
     * @param s1 the name of the var of the first Expression which will be a Var Expression
     * @param s2 the name of the var of the second Expression which will be a Var Expression
     */
    public Div(String s1, String s2) {
        super((new Var(s1)), new Var(s2));
    }

    /**
     * Div constructor.
     * @param n1 the value of the first Expression which will be a Num Expression.
     * @param n2 the value of the second Expression which will be a Num Expression.
     */
    public Div(double n1, double n2) {
        super((new Num(n1)), new Num(n2));
    }

    /**
     * evaluate Method divides the two expression according to the map it gets.
     * @param assignment the map for the values of the variables.
     * @return the result of the division between the two Expression.
     * @throws Exception in case an invalid Expression was received.
     */
    public double evaluate(Map<String, Double> assignment) throws Exception {
        try {
            return super.getE1().evaluate(assignment) / super.getE2().evaluate(assignment);
        } catch (Exception e) {
            System.out.println("No such expression!");
            throw e;
        }
    }

    /**
     * evaluate Method divides the two expression.
     * @return the result of the division between the two Expression..
     * @throws Exception in case an invalid Expression was received.
     */
    public double evaluate() throws Exception {
        try {
            return super.getE1().evaluate() / super.getE2().evaluate();
        } catch (Exception e) {
            System.out.println("No such expression!");
            throw e;
        }
    }

    /**
     * toString method returns the Expression in string the right string format.
     * @return the right string format of the expression.
     */
    public String toString() {
        return "(" + super.getE1().toString() + "/" + super.getE2().toString() + ")";
    }

    /**
     * assign Method finds the var wanted and replaces it with a new expression.
     * @param var the name of the var we want to replace.
     * @param expression the Expression we want to replace the Var with.
     * @return The new Expression with the Var replaced with the Expression.
     */
    public Expression assign(String var, Expression expression) {
        return new Div(super.getE1().assign(var, expression), super.getE2().assign(var, expression));
    }

    /**
     * differentiate method returns the derivative of the expression according to the var given.
     * @param var the var we will differentiate by.
     * @return The derivative by var of the expression.
     */
    public Expression differentiate(String var) {
        return new Neg(new Div(super.getE2().differentiate(var), new Pow(super.getE2(), 2)));
    }

    /**
     * simplify method simplifies the expression.
     * @return A simplified version on the expression.
     */
    public Expression simplify() {
        try {
            // Check if the Expression has no variables.
            if (getVariables().isEmpty()) {
                return new Num(evaluate());
            }
            // Check if e2 has no variables.
            if (super.getE2().getVariables().isEmpty()) {
                double res = super.getE2().evaluate();
                // Check if e2 equals 1.
                if (res < 1.00001) {
                    return super.getE1().simplify();
                }
                return new Div(super.getE1().simplify(), res);
            }
        } catch (Exception e) {
            return null;

        }
        // Check if e1 equals e2.
        if (super.getE1().toString().equals(super.getE2().toString())) {
            return new Num(1);
        }
        return new Div(super.getE1().simplify(), super.getE2().simplify());
    }

}
