import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 21/04/2016.
 */
public abstract class UnaryExpression extends BaseExpression {

    public UnaryExpression (Expression e1){
        super (e1);
    }

    public List<String> getVariables(){
        List newList = new ArrayList<String>();
        newList.addAll(e1.getVariables());
        return newList;
    }
}
