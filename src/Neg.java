import java.util.Map;

/**
 * Created by user on 20/04/2016.
 */
public class Neg extends UnaryExpression implements Expression {

    public Neg (Expression e){
        super(e);
    }

    public Neg (String s){
        super (new Var(s));
    }

    public Neg (double n){
        super (new Num (n));
    }

    public double evaluate(Map<String, Double> assignment) throws Exception{
        try {
            return e1.evaluate(assignment)*(-1);
        } catch(Exception e) {
            System.out.println("No such expression!");
            throw e;
        }
    }

    public double evaluate() throws Exception{
        try {
            return e1.evaluate()*(-1);
        } catch(Exception e) {
            System.out.println("No such expression!");
            throw e;
        }
    }

    public String toString(){
        return "(" + "-" + e1.toString() + ")";
    }

    public Expression assign(String var, Expression expression){
        return new Neg(e1.assign(var, expression));
    }

}
