/**
 * Created by user on 13/04/2016.
 */
public class Log {
    Var var;
    Num num;

    public Log (Var var, Num num){
        this.var=var;
        this.num=num;
    }

    public double getLog(){
        return var.getValue()+ num.getNum();
    }
}
