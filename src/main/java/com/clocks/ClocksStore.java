package com.clocks;

import com.clocks.Clocks;

import java.util.*;
import java.util.Comparator;

public class ClocksStore {

    ArrayList<Clocks> cl;
    Map<String, Integer> stat;

    public ClocksStore() {
        cl = new ArrayList<Clocks>();
    }
    public ClocksStore(ArrayList<Clocks> sl) {
        cl = new ArrayList();
        cl=sl;
    }
    public void setCl(Clocks sl) {
        cl.add(sl);
    }
    public String MostExpensive(){
        Comparator<Clocks> comp = new Comparator<Clocks>(){
            public int compare(Clocks o1, Clocks o2) {
                if (o1.getPrice()>o2.getPrice())
                    return 1;
                else
                if (o1.getPrice()==o2.getPrice())
                    return 0;
                else
                    return -1;
            }
        };
        Clocks maxp = Collections.max(cl, comp);
        System.out.println(maxp.getBrandClock());
        System.out.println(maxp.getPrice());
        return maxp.getBrandClock()+" "+Integer.toString(maxp.getPrice());
    }
    public void SetTheTime(int _hours, int _minutes, int _seconds) throws Exception {
        for(Clocks a: cl){
            a.SetTheTime("seconds",_seconds);
            a.SetTheTime("minutes",_minutes);
            a.SetTheTime("hours",_hours);
        }
    }

    public void SummStat(){
         stat = new HashMap<String, Integer>();
        for(Clocks a: cl)
            if (!stat.containsKey(a.getBrandClock()))
                stat.put(a.getBrandClock(), 1);

    }
    public void ChangeStat(String name){
        if (stat.containsKey(name))
            stat.put(name,stat.get(name)+1);
    }
    public String MaxStat(){
        int maxKey = Collections.max(stat.values());
        String b="";

        for (String key :stat.keySet() ) {
            if (stat.get(key).equals(maxKey)) {
                b=key+"  ";
            }
        }
        return b;
    }

    public TreeSet<String> SortTree( ){
        TreeSet<String> ts = new TreeSet();
        for (Clocks c: cl){
            if (!ts.contains(c.getBrandClock())){
                ts.add(c.getBrandClock());
            }
        }
        return ts;

    }
    public Integer getBrandValue(String name){
        for (Clocks c:cl){
            if (c.getBrandClock()==name){
                return c.getPrice();
            }
        }
        return null;
    }
}