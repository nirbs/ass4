import java.util.ArrayList;
import java.util.List;

/**
 * Created by Matan on 20/04/2016.
 */
public abstract class BaseExpression {
    protected Expression e1;


    public BaseExpression (Expression e){
        this.e1 = e;
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
        return newList;
    }






}
