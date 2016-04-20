import java.util.Map;

/**
 * Created by user on 13/04/2016.
 */
public class Log extends BaseExpression implements Expression{

    public Log (Expression e1, Expression e2){
        super(e1, e2);
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
        if (var.equals(this.toString())) {
            return expression;
        }
        else if ( (Expression) this instanceof Var) {
            return (Expression) this;
        }
        return new Log(e1.assign(var, expression), e2.assign(var,expression));
    }
}
