import java.util.Map;

/**
 * The Mult class creates a Multiply Expression between two different Expressions.
 * @author Matan Ben Noach Nir Ben Shalom
 * @version 1.0 9 April 2016
 */
public class Mult extends BinaryExpression implements Expression {

    /**
     * Mult constructor.
     * @param e1 the first Expression.
     * @param e2 the second Expression
     */
    public Mult (Expression e1, Expression e2){
        super(e1, e2);
    }

    /**
     * Mult constructor.
     * @param e the first Expression.
     * @param n the value of the second Expression which will be a Num Expression.
     */
    public Mult (Expression e, double n){
        super (e, new Num (n));
    }

    /**
     * Mult constructor.
     * @param e the first Expression.
     * @param s the name of the var of the second Expression which will be a Var Expression
     */
    public Mult (Expression e, String s){
        super (e, new Var (s));
    }

    /**
     * Mult constructor.
     * @param n the value of the first Expression which will be a Num Expression.
     * @param e the second Expression.
     */
    public Mult (double n, Expression e){
        super (new Num (n),e);
    }

    /**
     * Mult constructor.
     * @param s the name of the var of the first Expression which will be a Var Expression
     * @param e the second Expression
     */
    public Mult (String s, Expression e){
        super (new Var (s), e);
    }

    /**
     * Mult constructor.
     * @param v the name of the var of the first Expression which will be a Var Expression
     * @param n the value of the second Expression which will be a Num Expression.
     */
    public Mult (String v, double n){
        super ((new Var(v)), new Num (n));
    }

    /**
     * Mult constructor.
     * @param n the value of the second Expression which will be a Num Expression.
     * @param v the name of the var of the first Expression which will be a Var Expression
     */
    public Mult (double n, String v){
        super (new Num (n), (new Var(v)));
    }

    /**
     * Mult constructor.
     * @param s1 the name of the var of the first Expression which will be a Var Expression
     * @param s2 the name of the var of the second Expression which will be a Var Expression
     */
    public Mult (String s1, String s2){
        super ((new Var(s1)), new Var (s2));
    }

    /**
     * Mult constructor.
     * @param n1 the value of the first Expression which will be a Num Expression.
     * @param n2 the value of the second Expression which will be a Num Expression.
     */
    public Mult (double n1, double n2){
        super ((new Num(n1)), new Num (n2));
    }

    /**
     * evaluate Method multiplies the two expression according to the map it gets.
     * @param assignment the map for the values of the variables.
     * @return the result of the multiplication between the two Expression.
     * @throws Exception in case an invalid Expression was received.
     */
    public double evaluate(Map<String, Double> assignment) throws Exception{
        try {
            return e1.evaluate(assignment) * e2.evaluate(assignment);
        } catch(Exception e) {
            System.out.println("No such expression!");
            throw e;
        }
    }

    /**
     * evaluate Method multiplies the two expression.
     * @return the result of the multiplication between the two Expression.
     * @throws Exception in case an invalid Expression was received.
     */
    public double evaluate() throws Exception{
        try {
            return e1.evaluate() * e2.evaluate();
        } catch(Exception e) {
            System.out.println("No such expression!");
            throw e;
        }
    }

    /**
     * toString method returns the Expression in string the right string format.
     * @return the right string format of the expression.
     */
    public String toString(){
        return "(" + e1.toString()  + "*" + e2.toString() + ")";
    }

    /**
     * assign Method finds the var wanted and replaces it with a new expression.
     * @param var the name of the var we want to replace.
     * @param expression the Expression we want to replace the Var with.
     * @return The new Expression with the Var replaced with the Expression.
     */
    public Expression assign(String var, Expression expression) {
        return new Mult(e1.assign(var, expression), e2.assign(var,expression));
    }

    public Expression differentiate(String var) {
        return new Plus(new Mult(e1.differentiate(var),e2),new Mult(e1,e2.differentiate(var)));
    }

    public Expression simplify() {
        if (e1.getVariables().isEmpty()) {
            try {
                double res1 = e1.evaluate();
                if (res1 == 1) {
                    return e2.simplify();
                } else if (res1 == 0) {
                    return new Num(0);
                }
                return new Mult()
            } catch (Exception e) {
            }
        }

            double res = e1.evaluate();

        } catch (Exception e) {
            Expression exp = e1.simplify();

            try {
                if (e2.evaluate() == 1) {
                    return e1.simplify();
                }
                else if (e2.evaluate() == 0) {
                    return new Num(0);
                }
            } catch (Exception ex) {
                return new Mult(e1.simplify(), e2.simplify());
            }
        }
        try {
            if (e2.evaluate() == 1) {
                return e1;
            }
            else if (e2.evaluate() == 0) {
                return new Num(0);
            }
        } catch (Exception e) {
            try {
                if (e1.evaluate() == 1) {
                    return e2;
                } else if (e1.evaluate() == 0) {
                    return new Num(0);
                }
            } catch (Exception ex) {
                return new Mult(e1.simplify(), e2.simplify());
            }
        }
        return this;
    }
}
