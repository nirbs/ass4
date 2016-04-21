import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by user on 13/04/2016.
 */
public class Num implements Expression {
    double num; // The value of the Num

    /**
     * Num constructor.
     * @param num the value of the Num.
     */
    public Num (double num){
        this.num = num;
    }

    /**
     * toString method returns the Expression in string the right string format.
     * @return the right string format of the expression.
     */
    public String toString() {
        return Double.toString(this.num);
    }

    /**
     * evaluate method returns the value of the Num according to the map given.
     * @param assignment the map for the values of variables.
     * @return the value of the Num according to the map.
     * @throws Exception in case an invalid Expression was received.
     */
    public double evaluate(Map<String, Double> assignment) throws Exception {
        try {
            return assignment.get(toString());
        } catch(Exception e) {
            System.out.println("No such expression!");
            throw e;
        }
    }

    /**
     * evaluate method returns the value of the Num.
     * @return the value of the Num.
     * @throws Exception in case an invalid Expression was received.
     */
    public double evaluate() throws Exception {
        try {
            return this.num;
        } catch(Exception e) {
            System.out.println("No such expression!");
            throw e;
        }
    }


    /**
     * getVariables method an empty list because there is no variables in a Num Expression.
     * @return An empty list of strings.
     */
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
}
