import java.util.Map;

/**
 * Created by user on 20/04/2016.
*/

/**
 * The Cos class is in charge of the cosine calculation with the suitable methods.
 */
public class Cos extends UnaryExpression implements Expression {

    /**
     * The constructor gets an expression that inherits the
     * UnaryExpression methods.
     * @param e is an expression given by the user.
     */
    public Cos (Expression e){
        super(e,"cos");
    }

    /**
     * The constructor gets a var that inherits the
     * UnaryExpression methods.
     * @param s is a string given by the user.
     */
    public Cos (String s){
        super (new Var(s),"cos");
    }

    /**
     * The constructor gets a num that inherits the
     * UnaryExpression methods.
     * @param n is a double variable given by the user.
     */
    public Cos (double n){
        super (new Num (n),"cos");
    }


    /**
     * toString returns the string representation of cosine expression.
     * @return the string representation of cosine expression.
     */
    public String toString(){
        return "cos(" + e1.toString() + ")";
    }

    /**
     * assign is in charge of replacing a variable with an expression.
     * @param var is a given variable from the user
     * @param expression the expression to replace the variable
     * @return the new expression after the replacement
     */
    public Expression assign(String var, Expression expression){
        return new Cos(e1.assign(var, expression));
    }

    @Override
    public Expression differentiate(String var) {
        return new Neg(new Mult(e1.differentiate(var),new Sin(e1)));
    }

    @Override
    public Expression simplify() {
        Expression exp = super.simplify();
        return new Cos(exp);
    }

}

