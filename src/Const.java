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
        return null;
    }

    @Override
    public Expression assign(String var, Expression expression) {
        return null;
    }

    @Override
    public Expression differentiate(String var) {
        return null;
    }

    @Override
    public Expression simplify() {
        return null;
    }
}
