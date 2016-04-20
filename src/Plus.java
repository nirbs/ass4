import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by user on 13/04/2016.
 */
public class Plus implements Expression{
    Expression e1;
    Expression e2;

    public Plus (Expression e1, Expression e2){
        this.e1=e1;
        this.e2=e2;
    }

    public double evaluate(Map<String, Double> plus) throws Exception{
        if ((Expression) this instanceof Num) {
            Num myNum =  (Num) (Expression) this;
            return myNum.getNum();
        }
        else if ((Expression) this instanceof Var){
            return plus.get(this.toString());
        }
        return e1.evaluate(plus) + e2.evaluate(plus);
    }

    public double evaluate() throws Exception{
        if ((Expression) this instanceof Num) {
            Num myNum =  (Num) (Expression) this;
            return myNum.getNum();
        }
        return e1.evaluate()+ e2.evaluate();
    }

    public String toString(){
        return e1.toString() + "+" + e2.toString();
    }

    public Expression assign(String var, Expression expression){
        if (var == this.toString()) {
            return expression;
        }
        else if ( (Expression) this instanceof Var) {
            return this;
        }
        e1.assign(var, expression);
        e2.assign(var,expression);
    }

    public List<String> getVariables(){
        List newList = new ArrayList <String>();
        if ( (Expression) this instanceof Var) {
            Var newVar = (Var) (Expression) this;
            newList.add(newVar.getVar());
            return newList;
        }
        if ((Expression) this instanceof Num){
            return newList;
        }
        newList.addAll(e1.getVariables());
        newList.addAll(e2.getVariables());
        return newList;
    }
}
