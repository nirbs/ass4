/**
 * Created by user on 13/04/2016.
 */
public class Div {
    Var var;
    Num num;

    public Div (Var var, Num num){
        this.var=var;
        this.num=num;
    }

    public double getDiv(){
        return var.getValue()/ num.getNum();
    }
}
