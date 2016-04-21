import java.util.Map;

/**
 * The minus class creates a minus Expression between two different Expressions.
 * @author Matan Ben Noach Nir Ben Shalom
 * @version 1.0 9 April 2016
 */
public class Minus extends BinaryExpression implements Expression {

    /**
     * Minus constructor.
     * @param e1 the first Expression.
     * @param e2 the second Expression
     */
    public Minus (Expression e1, Expression e2){
        super(e1, e2);
    }

    /**
     * Minus constructor.
     * @param e the first Expression.
     * @param n the value of the second Expression which will be a Num Expression.
     */
    public Minus (Expression e, double n){
        super (e, new Num (n));
    }

    /**
     * Minus constructor.
     * @param e the first Expression.
     * @param s the name of the var of the second Expression which will be a Var Expression
     */
    public Minus (Expression e, String s){
        super (e, new Var (s));
    }

    /**
     * Minus constructor.
     * @param n the value of the first Expression which will be a Num Expression.
     * @param e the second Expression.
     */
    public Minus (double n, Expression e){
        super (e, new Num (n));
    }

    /**
     * Minus constructor.
     * @param s the name of the var of the first Expression which will be a Var Expression
     * @param e the second Expression
     */
    public Minus (String s, Expression e){
        super (e, new Var (s));
    }

    /**
     * Minus constructor.
     * @param v the name of the var of the first Expression which will be a Var Expression
     * @param n the value of the second Expression which will be a Num Expression.
     */
    public Minus (String v, double n){
        super ((new Var(v)), new Num (n));
    }

    /**
     * Minus constructor.
     * @param n the value of the second Expression which will be a Num Expression.
     * @param v the name of the var of the first Expression which will be a Var Expression
     */
    public Minus (double n, String v){
        super ((new Var(v)), new Num (n));
    }

    /**
     * Minus constructor.
     * @param s1 the name of the var of the first Expression which will be a Var Expression
     * @param s2 the name of the var of the second Expression which will be a Var Expression
     */
    public Minus (String s1, String s2){
        super ((new Var(s1)), new Var (s2));
    }

    /**
     * Minus constructor.
     * @param n1 the value of the first Expression which will be a Num Expression.
     * @param n2 the value of the second Expression which will be a Num Expression.
     */
    public Minus (double n1, double n2){
        super ((new Num(n1)), new Num (n2));
    }

    /**
     * evaluate Method subtracts the two expression according to the map it gets.
     * @param assignment the map for the values of the variables.
     * @return the result of the subtraction between the two Expression.
     * @throws Exception in case an invalid Expression was received.
     */
    public double evaluate(Map<String, Double> assignment) throws Exception{
        try {
            return e1.evaluate(assignment) - e2.evaluate(assignment);
        } catch(Exception e) {
            System.out.println("No such expression!");
            throw e;
        }
    }

    /**
     * evaluate Method subtracts the two expression.
     * @return the result of the subtraction between the two Expression.
     * @throws Exception in case an invalid Expression was received.
     */
    public double evaluate() throws Exception{
        try {
            return e1.evaluate() - e2.evaluate();
        } catch(Exception e) {
            System.out.println("No such expression!");
            throw e;
        }
    }

    /**
     * toString method returns the Expression in string the right string format.
     * @return the right string format of the expression.
     */
    public String toString() {
        return  "((" + e1.toString() + ")" + "-(" + e2.toString() + "))";
    }

    /**
     * assign Method finds the var wanted and replaces it with a new expression.
     * @param var the name of the var we want to replace.
     * @param expression the Expression we want to replace the Var with.
     * @return The new Expression with the Var replaced with the Expression.
     */
    public Expression assign(String var, Expression expression){
        return new Minus(e1.assign(var, expression), e2.assign(var,expression));
    }

}
