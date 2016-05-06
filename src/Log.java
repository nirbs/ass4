import java.util.Map;

/**
 * The Log class creates a log Expression between two different Expressions, the first Expression is the base and the
 * second is the result.
 *
 * @author Matan Ben Noach Nir Ben Shalom
 * @version 1.0 1 May 2016
 */
public class Log extends BinaryExpression implements Expression {

    /**
     * Log constructor.
     *
     * @param e1 the first Expression.
     * @param e2 the second Expression
     */
    public Log(Expression e1, Expression e2) {
        super(e1, e2);
    }

    /**
     * Log constructor.
     *
     * @param e the first Expression.
     * @param n the value of the second Expression which will be a Num Expression.
     */
    public Log(Expression e, double n) {
        super(e, new Num(n));
    }

    /**
     * Log constructor.
     *
     * @param e the first Expression.
     * @param s the name of the var of the second Expression which will be a Var Expression
     */
    public Log(Expression e, String s) {
        super(e, new Var(s));
    }

    /**
     * Log constructor.
     *
     * @param n the value of the first Expression which will be a Num Expression.
     * @param e the second Expression.
     */
    public Log(double n, Expression e) {
        super(new Num(n), e);
    }

    /**
     * Log constructor.
     *
     * @param s the name of the var of the first Expression which will be a Var Expression
     * @param e the second Expression
     */
    public Log(String s, Expression e) {
        super(new Var(s), e);
    }

    /**
     * Log constructor.
     *
     * @param v the name of the var of the first Expression which will be a Var Expression
     * @param n the value of the second Expression which will be a Num Expression.
     */
    public Log(String v, double n) {
        super((new Var(v)), new Num(n));
    }

    /**
     * Log constructor.
     *
     * @param n the value of the second Expression which will be a Num Expression.
     * @param v the name of the var of the first Expression which will be a Var Expression
     */
    public Log(double n, String v) {
        super(new Num(n), (new Var(v)));
    }

    /**
     * Log constructor.
     *
     * @param s1 the name of the var of the first Expression which will be a Var Expression
     * @param s2 the name of the var of the second Expression which will be a Var Expression
     */
    public Log(String s1, String s2) {
        super((new Var(s1)), new Var(s2));
    }

    /**
     * Log constructor.
     *
     * @param n1 the value of the first Expression which will be a Num Expression.
     * @param n2 the value of the second Expression which will be a Num Expression.
     */
    public Log(double n1, double n2) {
        super((new Num(n1)), new Num(n2));
    }

    /**
     * evaluate Method calculates the log with base of the first Expression and the result of the second Expression
     * according to the map it gets.
     *
     * @param assignment the map for the values of the variables.
     * @return the result of the log with the base of the first expression and the result of the second Expression.
     * @throws Exception in case an invalid Expression was received.
     */
    public double evaluate(Map<String, Double> assignment) throws Exception {
        try {
            return Math.log(super.getE2().evaluate(assignment)) / Math.log(super.getE1().evaluate(assignment));
        } catch (Exception e) {
            System.out.println("Can't evaluate");
            throw e;
        }
    }

    /**
     * evaluate Method calculates the log with base of the first Expression and the result of the second Expression.
     *
     * @return the result of the log with the base of the first expression and the result of the second Expression.
     * @throws Exception in case an invalid Expression was received.
     */
    public double evaluate() throws Exception {
        try {
            return Math.log(super.getE2().evaluate()) / Math.log(super.getE1().evaluate());
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
        return "log(" + super.getE1().toString() + ", " + super.getE2().toString() + ")";
    }

    /**
     * assign Method finds the var wanted and replaces it with a new expression.
     *
     * @param var        the name of the var we want to replace.
     * @param expression the Expression we want to replace the Var with.
     * @return The new Expression with the Var replaced with the Expression.
     */
    public Expression assign(String var, Expression expression) {
        return new Log(super.getE1().assign(var, expression), super.getE2().assign(var, expression));
    }

    /**
     * differentiate Method returns the derivative of the expression according to the var given.
     *
     * @param var the var we will differentiate by.
     * @return The derivative by var of the expression.
     */
    public Expression differentiate(String var) {
        return new Mult(new Div(1, (new Mult(super.getE2(), new Log(new Const("e", 2.71), super.getE1())))),
                super.getE2().differentiate(var));
    }

    /**
     * simplify method simplifies the expression.
     *
     * @return A simplified version on the expression.
     */
    public Expression simplify() {
        Expression exp1 = super.getE1().simplify();
        Expression exp2 = super.getE2().simplify();
        if (exp1.getVariables().isEmpty() && exp2.getVariables().isEmpty()) {
            try {
                return new Num(Math.log(exp2.evaluate()) / Math.log(exp1.evaluate()));
            } catch (Exception e) {
                return null;
            }
        }
        if (exp1.toString().equals(exp2.toString())) {
            return new Num(1);
        }
        return new Log(exp1, exp2);
    }
}
