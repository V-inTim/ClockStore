package com.clocks;

public class SecClocks extends Clocks{
    int seconds;

    public SecClocks(String brandClock, int price) {
        super(brandClock, price);

    }
    public void TransOfTime (String type, int par) throws Exception{
        if(type=="seconds"){
            if (par<0)
                throw new Exception("Time can not be turned back");
            if (seconds + par>=60)
                seconds= (seconds+par)%60;
            else
                seconds+=par;
        }else
            super.TransOfTime(type,par);


    }
    public void SetTheTime(String type, int par) throws Exception {
        if (type=="seconds")
            if (par>=0 && par<60){
                this.seconds=par;
            }
            else
                super.SetTheTime(type, par);
    }
}
