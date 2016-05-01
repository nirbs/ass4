import java.util.Map;

/**
 * The Plus class is a plus Expression between two Expressions.
 * @author Matan Ben Noach Nir Ben Shalom.
 * @version 1.0 1 May 2016.
 */
public class Plus extends BinaryExpression implements Expression {
    /**
     * Plus constructor.
     * @param e1 the first Expression.
     * @param e2 the second Expression
     */
    public Plus(Expression e1, Expression e2) {
        super(e1, e2);
    }

    /**
     * Plus constructor.
     * @param e the first Expression.
     * @param n the value of the second Expression which will be a Num Expression.
     */
    public Plus(Expression e, double n) {
        super(e, new Num(n));
    }

    /**
     * Plus constructor.
     * @param e the first Expression.
     * @param s the name of the var of the second Expression which will be a Var Expression
     */
    public Plus(Expression e, String s) {
        super(e, new Var(s));
    }

    /**
     * Plus constructor.
     * @param n the value of the first Expression which will be a Num Expression.
     * @param e the second Expression.
     */
    public Plus(double n, Expression e) {
        super(new Num(n), e);
    }

    /**
     * Plus constructor.
     * @param s the name of the var of the first Expression which will be a Var Expression
     * @param e the second Expression
     */
    public Plus(String s, Expression e) {
        super(new Var(s), e);
    }

    /**
     * Plus constructor.
     * @param v the name of the var of the first Expression which will be a Var Expression
     * @param n the value of the second Expression which will be a Num Expression.
     */
    public Plus(String v, double n) {
        super((new Var(v)), new Num(n));
    }

    /**
     * Plus constructor.
     * @param n the value of the second Expression which will be a Num Expression.
     * @param v the name of the var of the first Expression which will be a Var Expression
     */
    public Plus(double n, String v) {
        super(new Num(n), (new Var(v)));
    }

    /**
     * Plus constructor.
     * @param s1 the name of the var of the first Expression which will be a Var Expression
     * @param s2 the name of the var of the second Expression which will be a Var Expression
     */
    public Plus(String s1, String s2) {
        super((new Var(s1)), new Var(s2));
    }

    /**
     * Plus constructor.
     * @param n1 the value of the first Expression which will be a Num Expression.
     * @param n2 the value of the second Expression which will be a Num Expression.
     */
    public Plus(double n1, double n2) {
        super((new Num(n1)), new Num(n2));
    }

    /**
     * evaluate Method adds the two expression according to the map it gets.
     * @param assignment the map for the values of the variables.
     * @return the result of the addition between the two Expression.
     * @throws Exception in case an invalid Expression was received.
     */
    public double evaluate(Map<String, Double> assignment) throws Exception {
        try {
            return super.getE1().evaluate(assignment) + super.getE2().evaluate(assignment);
        } catch (Exception e) {
            System.out.println("Can't evaluate");
            throw e;
        }
    }

    /**
     * evaluate Method adds the two expression.
     * @return the result of the addition between the two Expression.
     * @throws Exception in case an invalid Expression was received.
     */
    public double evaluate() throws Exception {
        try {
            return super.getE1().evaluate() + super.getE2().evaluate();
        } catch (Exception e) {
            System.out.println("Can't evaluate");
            throw e;
        }
    }

    /**
     * toString method returns the Expression in string the right string format.
     * @return the right string format of the expression.
     */
    public String toString() {
        return "(" + super.getE1().toString() + "+" + super.getE2().toString() + ")";
    }

    /**
     * assign Method finds the var wanted and replaces it with a new expression.
     * @param var the name of the var we want to replace.
     * @param expression the Expression we want to replace the Var with.
     * @return The new Expression with the Var replaced with the Expression.
     */
    public Expression assign(String var, Expression expression) {
        return new Plus(super.getE1().assign(var, expression), super.getE2().assign(var, expression));
    }

    /**
     * differentiate Method returns the derivative of the expression according to the var given.
     * @param var the var we will differentiate by.
     * @return The derivative by var of the expression.
     */
    public Expression differentiate(String var) {
        return new Plus(super.getE1().differentiate(var), super.getE2().differentiate(var));
    }

    /**
     * simplify method simplifies the expression.
     * @return A simplified version on the expression.
     */
    public Expression simplify() {
        try {
            // Check if there are no variables in this Expression.
            if (getVariables().isEmpty()) {
                // Return the result of the expression.
                return new Num(evaluate());
            }
            // Check if there are no variables in e1 Expression.
            if (super.getE1().getVariables().isEmpty()) {
                double res = super.getE1().evaluate();
                // Check if e1 equals 0.
                if (res < 0.00001) {
                    return super.getE2().simplify();
                }
                return new Plus(res, super.getE2().simplify());
            }
            // Check if there are no variables in e2 Expression.
            if (super.getE2().getVariables().isEmpty()) {
                double res = super.getE2().evaluate();
                // Check if e2 equals 0.
                if (res < 0.00001) {
                    return super.getE1().simplify();
                }
                return new Plus(super.getE1().simplify(), res);
            }
        } catch (Exception e) {
            return null;
        }
        return new Plus(super.getE1().simplify(), super.getE2().simplify());
    }
}
