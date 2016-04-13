/**
 * Created by user on 13/04/2016.
 */
public class Mult {
    Var var;
    Num num;

    public Mult(Var var, Num num){
        this.var=var;
        this.num=num;
    }

    public double getMult(){
        return var.getValue()* num.getNum();
    }
}
