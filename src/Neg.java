import java.util.Map;

/**
 * Created by user on 20/04/2016.
 */
public class Neg extends BaseExpression implements Expression {

    public Neg (Expression e){
        super(e);
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
        if (var.equals(this.toString())) {
            return expression;
        }
        else if ( (Expression) this instanceof Var) {
            return (Expression) this;
        }
    }

}
