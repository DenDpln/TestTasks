package task2;

import java.util.Set;

/**
 * Created by den on 19.03.2015.
 */
public class StoreCash {
   public static CleanerOneHour clHour = null;
  // public static boolean  monitor = false;
    public static void messagesCome(){
        clHour = new CleanerOneHour();
        clHour.start();
        try {
            //Thread.sleep(500);
            JobCHMap.putCHMap(System.currentTimeMillis(), "mess1");
            cleanerOnTime();
            System.out.println(" ------------записано первое--------------------------------- ");

            Thread.sleep(25000);
            JobCHMap.putCHMap(System.currentTimeMillis(),"mess2");
            cleanerOnTime();
            System.out.println(" ------------записано второе--------------------------------- ");

            Thread.sleep(25000);
            JobCHMap.putCHMap(System.currentTimeMillis(),"mess3");
            cleanerOnTime();
            System.out.println(" -------------записано третье--------------------------------- ");

            Thread.sleep(15000);
            JobCHMap.putCHMap(System.currentTimeMillis(),"mess4");
            cleanerOnTime();
            System.out.println(" --------------записано четвёртое--------------------------------- ");

            Thread.sleep(10000);
            JobCHMap.putCHMap(System.currentTimeMillis(),"mess5");
            cleanerOnTime();
            System.out.println(" ---------------записано пятое--------------------------------- ");

            Thread.sleep(60000);
            JobCHMap.putCHMap(System.currentTimeMillis(),"mess6");
            cleanerOnTime();
            System.out.println(" ---------------записано шестое--------------------------------- ");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
      //  monitor = true;
    }
    public static void cleanerOnTime(){
        clHour.interrupt();
       // System.out.println(JobCHMap.getCHMap());
      long timeNow = System.currentTimeMillis();
        Set<Long> keyset=JobCHMap.getCHMap().keySet();
        for ( Long key : keyset){
           // System.out.println(key);
            if (key < timeNow-60000){
                System.out.println("протухло удалено - " + JobCHMap.get(key));
               JobCHMap.removeCHMap(key);
            } else {
                System.out.println("не протухло-  " + JobCHMap.get(key));
            }
        }
        System.out.println("всего сообщений +   " + "   " + "size= " + JobCHMap.sizeCHMap()+ "  " + JobCHMap.getCHMap());
     //   monitor = false;
        if (clHour.isInterrupted()){
            clHour = new CleanerOneHour();
            System.out.println("перезапуск ожидания ");
            clHour.start();}
        }
      public static void main(String[] args) {
        messagesCome();
    }

}
