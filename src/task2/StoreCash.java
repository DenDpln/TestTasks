package task2;

import java.util.*;

/**
 * Created by den on 19.03.2015.
 */
public class StoreCash {
   public static CleanerOneHour clHour = new CleanerOneHour();
    public static void messagesCome(){
        Date nowTime = null;
        nowTime = new Date();
        System.out.println("начало  "  + nowTime.getMinutes() + ":" + nowTime.getSeconds());
        clHour.start();
        try {
            nowTime = new Date();
            JobCHMap.putCHMap(System.currentTimeMillis(), "mess1");
            cleanerOnTime();
            System.out.println(" ------------записано первое--------------------------------- " + nowTime.getMinutes() + ":" + nowTime.getSeconds() );

            Thread.sleep(25000);
            nowTime = new Date();
            JobCHMap.putCHMap(System.currentTimeMillis(), "mess2");
            cleanerOnTime();
            System.out.println(" ------------записано второе--------------------------------- " + nowTime.getMinutes() + ":" + nowTime.getSeconds());

            Thread.sleep(25000);
            nowTime = new Date();
            JobCHMap.putCHMap(System.currentTimeMillis(), "mess3");
            cleanerOnTime();
            System.out.println(" -------------записано третье--------------------------------- " + nowTime.getMinutes() + ":" + nowTime.getSeconds());

            Thread.sleep(15000);
            nowTime = new Date();
            JobCHMap.putCHMap(System.currentTimeMillis(), "mess4");
            cleanerOnTime();
            System.out.println(" --------------записано четвёртое--------------------------------- " + nowTime.getMinutes() + ":" + nowTime.getSeconds());

            Thread.sleep(10000);
            nowTime = new Date();
            JobCHMap.putCHMap(System.currentTimeMillis(), "mess5");
            cleanerOnTime();
            System.out.println(" ---------------записано пятое--------------------------------- " + nowTime.getMinutes() + ":" + nowTime.getSeconds());

            Thread.sleep(60000);
            nowTime = new Date();
            JobCHMap.putCHMap(System.currentTimeMillis(), "mess6");
            cleanerOnTime();
            System.out.println(" ---------------записано шестое--------------------------------- " + nowTime.getMinutes() + ":" + nowTime.getSeconds());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void cleanerOnTime(){

        Date nowTime = new Date();
      long timeNow = System.currentTimeMillis();
        Set<Long> keyset= JobCHMap.getCHMap().keySet();
        for ( Long key : keyset){
            if (key <= timeNow-60000){
              //  clHour.interrupt();
                nowTime = new Date();
                System.out.println("протухло удалено - " + JobCHMap.get(key) + "  " + nowTime.getMinutes() + ":" + nowTime.getSeconds());
                JobCHMap.removeCHMap(key);
               // System.out.println(keyset);
                clHour = new CleanerOneHour();
                nowTime = new Date();
              //  System.out.println("перезапуск ожидания " + "  " + nowTime.getMinutes() + ":" + nowTime.getSeconds());
                clHour.start();
            } else {
             //   System.out.println("не протухло-  " + JobCHMap.get(key));
            }
        }

        }
      public static void main(String[] args) {
        messagesCome();
    }

}
