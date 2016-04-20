import java.util.ArrayList;
import java.util.List;

/**
 * Created by Matan on 20/04/2016.
 */
public abstract class BaseExpression {
        Expression e1;
        Expression e2;

    public BaseExpression (Expression e1, Expression e2){
        this.e1=e1;
        this.e2=e2;
    }

    public List<String> getVariables(){
        List newList = new ArrayList<String>();
        if ( (Expression) this instanceof Var) {
            return this.getVariables();
        }
        if ((Expression) this instanceof Num){
            return this.getVariables();
        }
        newList.addAll(e1.getVariables());
        newList.addAll(e2.getVariables());
        return newList;
    }


}
