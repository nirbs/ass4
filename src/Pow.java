/**
 * Created by user on 13/04/2016.
 */

public class Pow {
    Var var;
    Num num;

    public Pow (Var var, Num num){
        this.var=var;
        this.num=num;
    }

    public double getPow(){
        double x= var.getValue();
        for (int i=0; i<num.getNum(); i++){
            x*=x;
        }
        return x;
    }
}
