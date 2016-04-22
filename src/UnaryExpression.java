import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 21/04/2016.
 */

/**
 * The UnaryExpression is an abstract class the is used by every
 * unary expression. It inherits the base expression methods.
 */
public abstract class UnaryExpression extends BaseExpression {

    /**
     * The constructor creates an expression that gets the
     * BaseExpression methods
     * @param e1 is the expression given by the user.
     */
    public UnaryExpression (Expression e1){
        super (e1);
    }

}
