import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by user on 13/04/2016.
 */
public class Plus extends BinaryExpression implements Expression {

    /**
     * Plus constructor.
     * @param e1 the first Expression.
     * @param e2 the second Expression
     */
    public Plus (Expression e1, Expression e2){
        super(e1, e2, "+");
    }

    /**
     * Plus constructor.
     * @param e the first Expression.
     * @param n the value of the second Expression which will be a Num Expression.
     */
    public Plus (Expression e, double n){
        super (e, new Num (n), "+");
    }

    /**
     * Plus constructor.
     * @param e the first Expression.
     * @param s the name of the var of the second Expression which will be a Var Expression
     */
    public Plus (Expression e, String s){
        super (e, new Var (s), "+");
    }

    /**
     * Plus constructor.
     * @param n the value of the first Expression which will be a Num Expression.
     * @param e the second Expression.
     */
    public Plus (double n, Expression e){
        super (new Num (n),e, "+");
    }

    /**
     * Plus constructor.
     * @param s the name of the var of the first Expression which will be a Var Expression
     * @param e the second Expression
     */
    public Plus (String s, Expression e){
        super (new Var (s), e, "+");
    }

    /**
     * Plus constructor.
     * @param v the name of the var of the first Expression which will be a Var Expression
     * @param n the value of the second Expression which will be a Num Expression.
     */
    public Plus (String v, double n){
        super ((new Var(v)), new Num (n), "+");
    }

    /**
     * Plus constructor.
     * @param n the value of the second Expression which will be a Num Expression.
     * @param v the name of the var of the first Expression which will be a Var Expression
     */
    public Plus (double n, String v){
        super (new Num (n), (new Var(v)), "+");
    }

    /**
     * Plus constructor.
     * @param s1 the name of the var of the first Expression which will be a Var Expression
     * @param s2 the name of the var of the second Expression which will be a Var Expression
     */
    public Plus (String s1, String s2){
        super ((new Var(s1)), new Var (s2), "+");
    }

    /**
     * Plus constructor.
     * @param n1 the value of the first Expression which will be a Num Expression.
     * @param n2 the value of the second Expression which will be a Num Expression.
     */
    public Plus (double n1, double n2){
        super ((new Num(n1)), new Num (n2), "+");
    }

    /**
     * toString method returns the Expression in string the right string format.
     * @return the right string format of the expression.
     */
    public String toString(){
        return "(" + e1.toString() + "+" + e2.toString() + ")";
    }

    /**
     * assign Method finds the var wanted and replaces it with a new expression.
     * @param var the name of the var we want to replace.
     * @param expression the Expression we want to replace the Var with.
     * @return The new Expression with the Var replaced with the Expression.
     */
    public Expression assign(String var, Expression expression) {
        return new Plus(e1.assign(var, expression), e2.assign(var,expression));
    }

    @Override
    public Expression differentiate(String var) {
        return new Plus(e1.differentiate(var), e2.differentiate(var));
    }

    @Override
    public Expression simplify() {
        Expression exp1 = e1.simplify();
        Expression exp2 = e2.simplify();
        if (exp1.getVariables().isEmpty() && exp2.getVariables().isEmpty()) {
            try{
                return new Num(evaluate());
            } catch(Exception e) {

            }
        }
        if (exp1.getVariables().isEmpty()) {
            try {
                double res = exp1.evaluate();
                if (res == 0) {
                    return exp2.simplify();
                }
                return new Plus(new Num(res), exp2);
            } catch (Exception e) {
            }
        }
        if (exp2.getVariables().isEmpty())
            try {
                double res = exp2.evaluate();
                if (res == 0) {
                    return exp1.simplify();
                }
                return new Plus(new Num(res), exp1.simplify());
            } catch (Exception e) {
            }
        return new Plus(exp1, exp2);
    }
}
