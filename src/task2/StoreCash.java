package task2;

import javax.swing.text.html.parser.Entity;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by den on 19.03.2015.
 */
public class StoreCash {

    public static void messagesCome(){
        boolean  monitor = false;
        try {
            JobCHMap.putCHMap(System.currentTimeMillis(),"mess2");
            Thread.sleep(111);
            JobCHMap.putCHMap(System.currentTimeMillis(),"mess3");
            Thread.sleep(544);
            JobCHMap.putCHMap(System.currentTimeMillis(),"mess4");
            Thread.sleep(156);
            JobCHMap.putCHMap(System.currentTimeMillis(),"mess5");
            Thread.sleep(300);
            JobCHMap.putCHMap(System.currentTimeMillis(),"mess6");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        monitor = true;

    }
    public static void cleanerOnTime(){
        System.out.println(JobCHMap.getCHMap());
      long timeNow = System.currentTimeMillis();
        Set<Long> keyset=JobCHMap.getCHMap().keySet();
        for ( Long key : keyset){
            System.out.println(key);
            if (key<timeNow-1000){
               JobCHMap.removeCHMap(key);
            }
        }
        System.out.println(JobCHMap.getCHMap());
    }

    public static void main(String[] args) {
        messagesCome();
        cleanerOnTime();
    }
}
