package com.clocks;

public interface source {
    public String getBrandClock();
    public int getPrice();
    public void TransOfTime(String type, int par)throws Exception;
    public void SetTheTime(String type, int par)throws Exception;
}
