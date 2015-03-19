package task2;

import java.util.Set;

/**
 * Created by den on 19.03.2015.
 */
public class StoreCash {
   public static boolean  monitor = false;
    public static void messagesCome(){

        try {
            cleanerOnTime();
            JobCHMap.putCHMap(System.currentTimeMillis(),"mess2");
            cleanerOnTime();
            Thread.sleep(111);
            JobCHMap.putCHMap(System.currentTimeMillis(),"mess3");
            cleanerOnTime();
            Thread.sleep(544);
            JobCHMap.putCHMap(System.currentTimeMillis(),"mess4");
            cleanerOnTime();
            Thread.sleep(156);
            JobCHMap.putCHMap(System.currentTimeMillis(),"mess5");
            cleanerOnTime();
            Thread.sleep(300);
            JobCHMap.putCHMap(System.currentTimeMillis(),"mess6");
            cleanerOnTime();
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
            if (key < timeNow-1000){
               JobCHMap.removeCHMap(key);
            }
        }
        System.out.println(JobCHMap.getCHMap());
        monitor = false;
        }
      public static void main(String[] args) {
        messagesCome();
    }

}
