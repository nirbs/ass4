import java.util.ArrayList;
import java.util.List;

/**
 * Created by Matan on 20/04/2016.
 */
public abstract class BaseExpression {
        Expression e;


    public BaseExpression (Expression e){
        this.e=e;
    }

    public double evaluate() throws Exception{
        return e.evaluate();
    }

    public List<String> getVariables(){
        List newList = new ArrayList<String>();
        if ( (Expression) this instanceof Var) {
            return this.getVariables();
        }
        if ((Expression) this instanceof Num){
            return this.getVariables();
        }
        newList.addAll(e.getVariables());
        return newList;
    }




}
