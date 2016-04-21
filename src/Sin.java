import java.util.Map;

/**
 * Created by user on 20/04/2016.
 */
public class Sin extends UnaryExpression implements Expression {

    public Sin (Expression e){
        super(e);
    }

    public Sin (String s){
        super (new Var(s));
    }

    public Sin (double n){
        super (new Num (n));
    }

    public double evaluate(Map<String, Double> assignment) throws Exception{
        try {
            return Math.sin (e1.evaluate(assignment));
        } catch(Exception e) {
            System.out.println("No such expression!");
            throw e;
        }
    }

    public double evaluate() throws Exception{
        try {
            return Math.sin (e1.evaluate());
        } catch(Exception e) {
            System.out.println("No such expression!");
            throw e;
        }
    }

    public String toString(){
        return "(" + "sin(" + e1.toString() + "))";
    }

    public Expression assign(String var, Expression expression){
        return new Sin(e1.assign(var, expression));
    }
}
