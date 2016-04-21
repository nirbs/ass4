import java.util.Map;

/**
 * Created by user on 20/04/2016.
*/
public class Cos extends UnaryExpression implements Expression {

    public Cos (Expression e){
        super(e);
    }

    public Cos (String s){
        super (new Var(s));
    }

    public Cos (double n){
        super (new Num (n));
    }

    public double evaluate(Map<String, Double> assignment) throws Exception{
        try {
            return Math.cos (e1.evaluate(assignment));
        } catch(Exception e) {
            System.out.println("No such expression!");
            throw e;
        }
    }

    public double evaluate() throws Exception{
        try {
            return Math.cos (e1.evaluate());
        } catch(Exception e) {
            System.out.println("No such expression!");
            throw e;
        }
    }

    public String toString(){
        return "(" + "cos(" + e1.toString() + "))";
    }

    public Expression assign(String var, Expression expression){
        return new Cos(e1.assign(var, expression));
    }

}

