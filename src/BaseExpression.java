import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Matan on 20/04/2016.
 */

/**
 * The BaseExpression is an abstract class the is used by the
 * BinaryExpression and the UnaryExpression classes.
 */
public abstract class BaseExpression {
    protected Expression e1; // The member which holds an expression
    protected String sign;

    /**
     *  The constructor creates an expression.
     * @param e is the expression given by the user.
     */
    public BaseExpression (Expression e, String sign){
        this.e1 = e;
        this.sign = sign;
    }

    /**
     * evaluate Method divides the two expression according to the map it gets.
     * @param assignment the map for the values of the variables.
     * @return the result of the division between the two Expression.
     * @throws Exception in case an invalid Expression was received.
     */
    public double evaluate(Map<String, Double> assignment) throws Exception{
        double res = 0;
        try {
            switch(sign) {
                case "cos":
                    res = Math.cos (e1.evaluate(assignment));
                    break;
                case "sin":
                    res = Math.sin (e1.evaluate(assignment));
                    break;
                case "neg":
                    res = e1.evaluate(assignment)*(-1);
                    break;
                default:
                    break;
            }
        } catch(Exception e) {
            System.out.println("Can't evaluate!");
            throw e;
        }
        return res;
    }

    /**
     * evaluate Method divides the two expression.
     * @return the result of the division between the two Expression.
     * @throws Exception in case an invalid Expression was received.
     */
    public double evaluate() throws Exception{
        double res = 0;
        try {
            switch(sign) {
                case "cos":
                    res = Math.cos (e1.evaluate());
                    break;
                case "sin":
                    res = Math.sin (e1.evaluate());
                    break;
                case "neg":
                    res = e1.evaluate()*(-1);
                    break;
                default:
                    break;
            }
        } catch(Exception e) {
            System.out.println("Can't evaluate!");
            throw e;
        }
        return res;
    }



    /**
     * getVariables creates and returns a list with all of the
     * variables in every expression.
     * @return a list with the variables in the expression.
     */
    public List<String> getVariables() {
        List newList = new ArrayList<String>();
        newList.addAll(e1.getVariables());
        return newList;
    }

    public Expression simplify() {
        Expression exp = e1.simplify();
        if (exp.getVariables().isEmpty()) {
            try {
                new Num(exp.evaluate());
            } catch (Exception e) {

            }
        }
        return exp;
    }

}
