/**
 * Created by user on 13/04/2016.
 */
public class Plus {
    Var var;
    Num num;

    public Plus (Var var, Num num){
        this.var=var;
        this.num=num;
    }

    public double getPlus(){
        return var.getValue()+ num.getNum();
    }
}
