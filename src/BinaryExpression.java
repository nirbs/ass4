import java.util.List;
import java.util.Map;

/**
 * Created by Matan on 20/04/2016.
 */

/**
 * The BinaryExpression is an abstract class the is used by every
 * binary expression. It inherits the base expression methods.
 */
public abstract class BinaryExpression extends BaseExpression {
    protected Expression e2; //The member which doesn't inherit the BaseExpression methods

    /**
     *  The constructor creates 2 expressions: The first gets the
     * BaseExpression methods and the second does'nt.
     * @param e1 is the expression given by the user and inherits the BaseExpression methods.
     * @param e2 is the expression given by the user and it's only a BinaryExpression member.
     */
    public BinaryExpression(Expression e1, Expression e2, String sign) {
        super(e1,sign);
        this.e2 = e2;
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
                case "+":
                    res = e1.evaluate(assignment) + e2.evaluate(assignment);
                    break;
                case "-":
                    res = e1.evaluate(assignment) - e2.evaluate(assignment);
                    break;
                case "*":
                    res = e1.evaluate(assignment) * e2.evaluate(assignment);
                    break;
                case "/":
                    res = e1.evaluate(assignment) / e2.evaluate(assignment);
                    break;
                case "log":
                    res = Math.log(e1.evaluate(assignment)) / Math.log(e2.evaluate(assignment));
                    break;
                case "^":
                    res = Math.pow(e1.evaluate(assignment), e2.evaluate(assignment));
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
     * @return the result of the division between the two Expression..
     * @throws Exception in case an invalid Expression was received.
     */
    public double evaluate() throws Exception{
        double res = 0;
        try {
            switch(sign) {
                case "+":
                    res = e1.evaluate() + e2.evaluate();
                    break;
                case "-":
                    res = e1.evaluate() - e2.evaluate();
                    break;
                case "*":
                    res = e1.evaluate() * e2.evaluate();
                    break;
                case "/":
                    res = e1.evaluate() / e2.evaluate();
                    break;
                case "log":
                    res = Math.log(e1.evaluate()) / Math.log(e2.evaluate());
                    break;
                case "^":
                    res = Math.pow(e1.evaluate(), e2.evaluate());
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
     * @return a list with the variables in the 2 expressions.
     */
    public List<String> getVariables() {
        List newList = super.getVariables();
        newList.addAll(e2.getVariables());
        return newList;
    }



}
