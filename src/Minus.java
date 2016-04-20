import java.util.List;
import java.util.Map;

/**
 * Created by user on 13/04/2016.
 */
public class Minus implements Expression {
    Expression e1;
    Expression e2;

    public Minus (Expression e1, Expression e2){
        this.e1=e1;
        this.e2=e2;
    }

    public double evaluate(Map<String, Double> assignment) throws Exception {
        if ((Expression) this instanceof Num) {
            Num myNum =  (Num) (Expression) this;
            return myNum.getNum();
        }
        else if ((Expression) this instanceof Var){
            return assignment.get(this.toString());
        }
        return e1.evaluate(assignment) - e2.evaluate(assignment);
    }

    @Override
    public double evaluate() throws Exception {
        return 0;
    }

    @Override
    public List<String> getVariables() {
        return null;
    }

    @Override
    public Expression assign(String var, Expression expression) {
        return null;
    }
}
