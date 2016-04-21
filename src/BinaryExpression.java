import java.util.ArrayList;
import java.util.List;

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
    public BinaryExpression(Expression e1, Expression e2) {
        super(e1);
        this.e2 = e2;
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
