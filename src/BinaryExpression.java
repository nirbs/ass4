/**
 * Created by Matan on 20/04/2016.
 */
public abstract class BinaryExpression extends BaseExpression {
    protected Expression e2;
    public BinaryExpression(Expression e1, Expression e2) {
        super(e1);
        this.e2 = e2;
    }


}
