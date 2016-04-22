import java.util.Map;

/**
 * Created by user on 20/04/2016.
 */

/**
 * The Neg class is in charge of the negative calculation with the suitable methods.
 */
public class Neg extends UnaryExpression implements Expression {

    /**
     * The constructor gets an expression that inherits the
     * UnaryExpression methods.
     * @param e is an expression given by the user.
     */
    public Neg (Expression e){
        super(e, "neg");
    }

    /**
     * The constructor gets a var that inherits the
     * UnaryExpression methods.
     * @param s is a string given by the user.
     */
    public Neg (String s){
        super (new Var(s), "neg");
    }

    /**
     * The constructor gets a num that inherits the
     * UnaryExpression methods.
     * @param n is a double variable given by the user.
     */
    public Neg (double n){
        super (new Num (n), "neg");
    }

    /**
     * toString returns the string representation of negative expression.
     * @return the string representation of negative expression.
     */
    public String toString(){
        return "(" + "-" + e1.toString() + ")";
    }

    /**
     * assign is in charge of replacing a variable with an expression.
     * @param var is a given variable from the user
     * @param expression the expression to replace the variable
     * @return the new expression after the replacement
     */
    public Expression assign(String var, Expression expression){
        return new Neg(e1.assign(var, expression));
    }

    @Override
    public Expression differentiate(String var) {
        return new Mult(-1,e1.differentiate(var));
    }

    @Override
    public Expression simplify() {
        Expression exp = e1.simplify();
        if (exp.getVariables().isEmpty()) {
            try {
                new Num(exp.evaluate());
            } catch(Exception e) {

            }
        }
        return new Neg(exp);
    }
}

