import java.util.Map;

/**
 * Created by user on 13/04/2016.
 */
public class Log extends BinaryExpression implements Expression{

    public Log (Expression e1, Expression e2){
        super(e1, e2);
    }

    public Log (String v, double n){
        super ((new Var(v)), new Num (n));
    }

    public Log (String s1, String s2){
        super ((new Var(s1)), new Var (s2));
    }

    public Log (double n1, double n2){
        super ((new Num(n1)), new Num (n2));
    }

    public double evaluate(Map<String, Double> assignment) throws Exception{
        try {
            return Math.log(e1.evaluate(assignment)) / Math.log(e2.evaluate(assignment));
        } catch(Exception e) {
            System.out.println("No such expression!");
            throw e;
        }
    }

    public double evaluate() throws Exception{
        try {
            return Math.log(e1.evaluate()) / Math.log(e2.evaluate());
        } catch(Exception e) {
            System.out.println("No such expression!");
            throw e;
        }
    }

    public String toString(){
        return "(log(" + e1.toString() + "," + e2.toString()  + "))";
    }

    public Expression assign(String var, Expression expression){
        return new Log(e1.assign(var, expression), e2.assign(var,expression));
    }
}
