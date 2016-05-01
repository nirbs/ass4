/**
 * The UnaryExpression is an abstract class the is used by every unary expression.
 * It inherits the base expression methods.
 * @author Matan Ben Noach Nir Ben Shalom.
 * @version 1.0 1 May 2016.
 */
public abstract class UnaryExpression extends BaseExpression {

    /**
     * The constructor creates an expression that gets the
     * BaseExpression methods.
     * @param e1 is the expression given by the user.
     */
    public UnaryExpression(Expression e1) {
        super(e1);
    }

}
