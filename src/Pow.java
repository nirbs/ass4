import java.util.Map;

/**
 * The Pow class is a pow Expression between two Expressions.
 * @author Matan Ben Noach Nir Ben Shalom.
 * @version 1.0 1 May 2016.
 */
public class Pow extends BinaryExpression implements Expression {

    /**
     * Pow constructor.
     * @param e1 the first Expression.
     * @param e2 the second Expression
     */
    public Pow(Expression e1, Expression e2) {
        super(e1, e2);
    }

    /**
     * Pow constructor.
     * @param e the first Expression.
     * @param n the value of the second Expression which will be a Num Expression.
     */
    public Pow(Expression e, double n) {
        super(e, new Num(n));
    }

    /**
     * Pow constructor.
     * @param e the first Expression.
     * @param s the name of the var of the second Expression which will be a Var Expression
     */
    public Pow(Expression e, String s) {
        super(e, new Var(s));
    }

    /**
     * Pow constructor.
     * @param n the value of the first Expression which will be a Num Expression.
     * @param e the second Expression.
     */
    public Pow(double n, Expression e) {
        super(new Num(n), e);
    }


    /**
     * Pow constructor.
     * @param s the name of the var of the first Expression which will be a Var Expression
     * @param e the second Expression
     */
    public Pow(String s, Expression e) {
        super(new Var(s), e);
    }

    /**
     * Pow constructor.
     * @param v the name of the var of the first Expression which will be a Var Expression
     * @param n the value of the second Expression which will be a Num Expression.
     */
    public Pow(String v, double n) {
        super((new Var(v)), new Num(n));
    }

    /**
     * Pow constructor.
     * @param n the value of the second Expression which will be a Num Expression.
     * @param v the name of the var of the first Expression which will be a Var Expression
     */
    public Pow(double n, String v) {
        super(new Num(n), (new Var(v)));
    }

    /**
     * Pow constructor.
     * @param s1 the name of the var of the first Expression which will be a Var Expression
     * @param s2 the name of the var of the second Expression which will be a Var Expression
     */
    public Pow(String s1, String s2) {
        super((new Var(s1)), new Var(s2));
    }

    /**
     * Pow constructor.
     * @param n1 the value of the first Expression which will be a Num Expression.
     * @param n2 the value of the second Expression which will be a Num Expression.
     */
    public Pow(double n1, double n2) {
        super((new Num(n1)), new Num(n2));
    }

    /**
     * evaluate Method calculates first Expression in the power of the second Expression according to the map it gets.
     * @param assignment the map for the values of the variables.
     * @return the result of the power between the two Expression.
     * @throws Exception in case an invalid Expression was received.
     */
    public double evaluate(Map<String, Double> assignment) throws Exception {
        try {
            return Math.pow(super.getE1().evaluate(assignment), super.getE2().evaluate(assignment));
        } catch (Exception e) {
            System.out.println("No such expression!");
            throw e;
        }
    }

    /**
     * evaluate Method calculates first Expression in the power of the second Expression.
     * @return the result of the power between the two Expression.
     * @throws Exception in case an invalid Expression was received.
     */
    public double evaluate() throws Exception {
        try {
            return Math.pow(super.getE1().evaluate(), super.getE2().evaluate());
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
        return "(" + super.getE1().toString() + "^" + super.getE2().toString() + ")";
    }

    /**
     * assign Method finds the var wanted and replaces it with a new expression.
     * @param var the name of the var we want to replace.
     * @param expression the Expression we want to replace the Var with.
     * @return The new Expression with the Var replaced with the Expression.
     */
    public Expression assign(String var, Expression expression) {
        return new Pow(super.getE1().assign(var, expression), super.getE2().assign(var, expression));
    }

    /**
     * differentiate Method returns the derivative of the expression according to the var given.
     * @param var the var we will differentiate by.
     * @return The derivative by var of the expression.
     */
    public Expression differentiate(String var) {
        return new Mult(this,
                new Plus(new Mult(super.getE1().differentiate(var),
                        new Div(super.getE2(), super.getE1())), new Mult(super.getE2().differentiate(var),
                        new Log(new Const("e", 2.71), super.getE1()))));
    }


    /**
     * simplify method simplifies the expression.
     * @return A simplified version on the expression.
     */
    public Expression simplify() {
        Expression exp1 = super.getE1().simplify();
        Expression exp2 = super.getE2().simplify();
        try {
            if (exp1.getVariables().isEmpty() && exp2.getVariables().isEmpty()) {
                new Num(Math.pow(exp1.evaluate(), exp2.evaluate()));
            }

            // Bonus part x^0 => 1.
            if (exp2.getVariables().isEmpty()) {
                if (Math.abs(exp2.evaluate()) < 0.00001) {
                    return new Num(1);
                }
            }

        } catch (Exception e) {
            return null;
        }

        // Bonus part x^y^z => x^(y*z).
        if (exp1 instanceof Pow) {
            return new Pow(((Pow) exp1).getE1(), new Mult(((Pow) exp1).getE2(), exp2));
        }

        return new Pow(exp1, exp2);
    }
}
