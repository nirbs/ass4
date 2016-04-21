import java.util.ArrayList;
import java.util.List;

/**
 * Created by Matan on 20/04/2016.
 */

/**
 * The BaseExpression is an abstract class the is used by the
 * BinaryExpression and the UnaryExpression classes.
 */
public abstract class BaseExpression {
    protected Expression e1; //The member which holds an expression

    /**
     *  The constructor creates an expression.
     * @param e is the expression given by the user.
     */
    public BaseExpression (Expression e){
        this.e1 = e;
    }
}
