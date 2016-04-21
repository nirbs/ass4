import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by user on 13/04/2016.
 */
public class Var implements Expression{
    String var;
    double value;

    public Var(String var){
        this.var=var;
    }

    public void setVar(String var) {
        this.var = var;
    }

    public void setValue(double val) {
        value = val;
    }

    public double evaluate(Map<String, Double> assignment) throws Exception{
        return assignment.get(this.var);
    }
    public double evaluate() throws Exception{
        return this.value;
    }
    public List<String> getVariables(){
        List l = new ArrayList<String>();
        l.add(this.var);
        return l;
    }
    public String toString(){
        return this.var;
    }

    public Expression assign(String var, Expression expression) {
        if (var.equals(this.toString())) {
            return expression;
        }
        return this;
    }

}