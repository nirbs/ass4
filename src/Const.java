import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Matan on 21/04/2016.
 */
public class Const implements Expression {
    private String name;
    private double value;

    public Const(String name, double value) {
        this.name = name;
        this.value = value;
    }

    public double evaluate(Map<String, Double> assignment) throws Exception {
        try {
            return assignment.get(name);
        } catch (Exception e) {
            throw e;
        }
    }

    public double evaluate() throws Exception {
        try {
            return this.value;
        } catch (Exception e) {
            throw e;
        }
    }

    public String toString() {
        return name;
    }

    @Override
    public List<String> getVariables() {
        List l = new ArrayList<String>();
        return l;
    }

    /**
     * assign Method returns this Num because Num is not a variable so we cant assign it.
     * @param var the name of the var we want to replace.
     * @param expression the Expression we want to replace the Var with.
     * @return This num.
     */
    public Expression assign(String var, Expression expression) {
        return this;
    }

    @Override
    public Expression differentiate(String var) {
        return new Num(0);
    }

    @Override
    public Expression simplify() {
        return this;
    }
}
