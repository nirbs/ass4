import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by user on 13/04/2016.
 */
public class Var implements Expression{
    String var; // The name of the var.

    /**
     * Var constructor.
     * @param var the name of the var.
     */
    public Var(String var){
        this.var = var;
    }

    /**
     * evaluate method returns the value of the Var according to the map given.
     * @param assignment the map for the values of variables.
     * @return the value of the Var according to the map.
     * @throws Exception in case an invalid Expression was received.
     */
    public double evaluate(Map<String, Double> assignment) throws Exception {
        try {
            return assignment.get(this.var);
        }
        catch (Exception e) {
            System.out.println("No such expression!");
            throw e;
        }
    }

    /**
     * evaluate method throws an exception because we cant evaluate a variable value without a map.
     * @throws Exception in case there is no map.
     */
    public double evaluate() throws Exception{
        throw new Exception("Cant get value without map");
    }

    /**
     * getVariables method returns a list with one name of a Var which is this Var.
     * @return A list of strings which will include only this Var name.
     */
    public List<String> getVariables(){
        List l = new ArrayList<String>();
        l.add(this.var);
        return l;
    }

    /**
     * toString method returns the Expression in string the right string format.
     * @return the right string format of the expression.
     */
    public String toString(){
        return this.var;
    }

    /**
     * assign Method checks if this is the Var were looking for and if so returns the Expression to replace it,
     * otherwise the method return this Var.
     * @param var the name of the var we want to replace.
     * @param expression the Expression we want to replace the Var with.
     * @return The new Expression with the Var replaced with the Expression if this is the Var were looking for,
     * otherwise the method this Var.
     */
    public Expression assign(String var, Expression expression) {
        if (var.equals(this.toString())) {
            return expression;
        }
        return this;
    }

    public Expression differentiate(String var) {
        if (var.equals(this.toString())) {
            return new Num(1);
        }
        return new Num(0);
    }

}