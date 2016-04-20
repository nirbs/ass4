import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by user on 13/04/2016.
 */
public class Num implements Expression {
    double num;

    public Num (double num){
        this.num = num;
    }

    public void setNum(double newNum) {
        this.num = newNum;
    }

    public double evaluate(Map<String, Double> assignment) throws Exception {
        return this.num;
    }

    public double evaluate() throws Exception {
        return this.num;
    }

    public List<String> getVariables() {
        List l = new ArrayList<String>();
        return l;
    }

    public Expression assign(String var, Expression expression) {
        return null;
    }
}
