/**
 * Created by user on 13/04/2016.
 */
public class Minus {
    Var var;
    Num num;

    public Minus (Var var, Num num){
        this.var=var;
        this.num=num;
    }

    public double getMinus(){
        return var.getValue()- num.getNum();
    }
}
