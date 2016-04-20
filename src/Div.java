import java.util.Map;

/**
 * Created by user on 13/04/2016.
 */
public class Div extends BaseExpression implements Expression {

    public Div (Expression e1, Expression e2){
        super(e1, e2);
    }

    public double evaluate(Map<String, Double> assignment) throws Exception{
        try {
            return e1.evaluate(assignment) / e2.evaluate(assignment);
        } catch(Exception e) {
            System.out.println("No such expression!");
            throw e;
        }
    }

    public double evaluate() throws Exception{
        try {
            return e1.evaluate() / e2.evaluate();
        } catch(Exception e) {
            System.out.println("No such expression!");
            throw e;
        }
    }

    public String toString(){
        return "((" + e1.toString() + ")" + "/(" + e2.toString() + "))";
    }

    public Expression assign(String var, Expression expression){
        if (var.equals(this.toString())) {
            return expression;
        }
        else if ( (Expression) this instanceof Var) {
            return (Expression) this;
        }
        return new Div(e1.assign(var, expression), e2.assign(var,expression));
    }

}
