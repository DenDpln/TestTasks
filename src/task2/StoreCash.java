package task2;

import java.util.*;

/**
 * механизм кеширования текстовых сообщений со сроком жизни не более 1 часа (одной минуты)
 */
public class StoreCash {
    protected static long ttl = 60000; //одна минута
    private static CleanerOneHour clHour = new CleanerOneHour();
    private static void messagesCome(){
        Date nowTime = null;
        nowTime = new Date();
        System.out.println("начало  "  + nowTime.getMinutes() + ":" + nowTime.getSeconds());
        clHour.start();
        try {
            nowTime = new Date();
            JobCHMap.putCHMap(System.currentTimeMillis(), "mess1");
            System.out.println("---------записано первое--------- " + nowTime.getMinutes() + ":" + nowTime.getSeconds());

            Thread.sleep(25000);
            nowTime = new Date();
            JobCHMap.putCHMap(System.currentTimeMillis(), "mess2");
            System.out.println("---------записано второе--------- " + nowTime.getMinutes() + ":" + nowTime.getSeconds());

            Thread.sleep(25000);
            nowTime = new Date();
            JobCHMap.putCHMap(System.currentTimeMillis(), "mess3");
            System.out.println("-----------записано третье------- " + nowTime.getMinutes() + ":" + nowTime.getSeconds());

            Thread.sleep(15000);
            nowTime = new Date();
            JobCHMap.putCHMap(System.currentTimeMillis(), "mess4");
            System.out.println("-----------записано четвёртое---- " + nowTime.getMinutes() + ":" + nowTime.getSeconds());

            Thread.sleep(40000);
            nowTime = new Date();
            JobCHMap.putCHMap(System.currentTimeMillis(), "mess5");
            System.out.println("-----------записано пятое-------- " + nowTime.getMinutes() + ":" + nowTime.getSeconds());

            Thread.sleep(60000);
            nowTime = new Date();
            JobCHMap.putCHMap(System.currentTimeMillis(), "mess6");
            System.out.println("------------записано шестое------ " + nowTime.getMinutes() + ":" + nowTime.getSeconds());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    protected static void  cleanerOnTime(){

        Date nowTime = new Date();
        long timeNow = System.currentTimeMillis();
        if (!JobCHMap.getCHMap().isEmpty()&&JobCHMap.getCHMap().firstKey()<=timeNow-ttl){
            System.out.println("протухло удалено - " + JobCHMap.getCHMap().firstKey() + "  " + nowTime.getMinutes() + ":" + nowTime.getSeconds());
            JobCHMap.removeFirst();
            System.out.println("хранится сообщений -  " + JobCHMap.getValue());
            clHour.run();
        }
    }
    public static void main(String[] args) {
        messagesCome();
    }

}