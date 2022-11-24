package com.clocks;

public class Clocks implements source{
    int minutes, hours, price;
    String brandClock;

    public Clocks( String brandClock, int price  ) {

        this.price = price;
        this.brandClock = brandClock;
    }

    public int getPrice() {
        return price;
    }

    public String getBrandClock() {
        return brandClock;
    }
    public void TransOfTime (String type, int par) throws Exception {
        if(type == "minutes"){
            if (par<0)
                throw new Exception("Time can not be turned back");
            if (minutes + par>=60)
                minutes= (minutes+par)%60;
            else
                minutes+=par;
        }else if (type=="hours"){
            if (par<0)
                throw new Exception("Time can not be turned back");
            if (hours + par>=12)
                hours= (hours+par)%12;
            else
                hours+=par;
        }


    }
    public void SetTheTime(String type, int par)throws Exception{
        if (type=="minutes"){
            if (par>=0 && par<60){
                this.minutes=par;
            }else
                throw new Exception("Time can not set");
        }else
        if (type=="hours"){
            if (par>=0 && par<60){
                this.hours=hours;
            }else
                throw new Exception("Time can not set");
        }

    }
}
