import java.util.ArrayList;
import java.util.List;

/**
 * The BaseExpression is an abstract class the is used by the
 * BinaryExpression and the UnaryExpression classes.
 */
public abstract class BaseExpression {
    private Expression e1; //The member which holds an expression

    /**
     * The constructor creates an expression.
     * @param e is the expression given by the user.
     */
    public BaseExpression(Expression e) {
        this.e1 = e;
    }

    /**
     * getVariables creates and returns a list with all of the
     * variables in every expression.
     * @return a list with the variables in the expression.
     */
    public List<String> getVariables() {
        List<String> newList = new ArrayList<String>();
        List<String> updateList = e1.getVariables();
        for (String s : updateList) {
            if (!newList.contains(s)) {
                newList.add(s);
            }
        }
        newList.addAll(e1.getVariables());
        return newList;
    }

    /**
     * getE1 returns the e1 Expression.
     * @return a the e1 Expression
     */
    public Expression getE1() {
        return e1;
    }
}
