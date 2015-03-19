package task2;

import javax.swing.text.html.parser.Entity;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by den on 19.03.2015.
 */
public class StoreCash {

    public static void messagesCome(){
        boolean  monitor = false;
        try {
            JobCHMap.putCHMap("mess1",System.currentTimeMillis());
            Thread.sleep(111);
            JobCHMap.putCHMap("mess2",System.currentTimeMillis());
            Thread.sleep(544);
            JobCHMap.putCHMap("mess3",System.currentTimeMillis());
            Thread.sleep(156);
            JobCHMap.putCHMap("mess4",System.currentTimeMillis());
            Thread.sleep(300);
            JobCHMap.putCHMap("mess5",System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        monitor = true;
        System.out.println(JobCHMap.getCHMap());
        System.out.println(JobCHMap.sizeCHMap());
        Map<String, Long> map = JobCHMap.getCHMap();
        for( Map.Entry<String, Long> entry : map.entrySet() ){
            if (entry.getValue()<System.currentTimeMillis()){
                System.out.println("!!!!!!!!!!1");
            }
            System.out.println( entry.getKey() + " " + entry.getValue() );
        }

    }
    public static void cleanerOnTime(){
      long timeNow = System.currentTimeMillis();
      int sizeCHM = JobCHMap.sizeCHMap();
//      for(ConcurrentHashMap.Entry<String,Long> entry : JobCHMap.getCHMap().entrySet()){
//          System.out.println( entry.getKey() + " " + entry.getValue() );
//      }

    }

    public static void main(String[] args) {
        messagesCome();
    }
}
