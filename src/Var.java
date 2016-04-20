/**
 * Created by user on 13/04/2016.
 */
public class Var {
    String var;
    Expression value;

    public Var(String var){
        this.var=var;
    }

    public String getVar() {
        return var;
    }

    public void setVar(String var) {
        this.var = var;
    }

    public Expression getValue() {
        return value;
    }

    public void setValue(Expression e) {
        value = e;
    }
}