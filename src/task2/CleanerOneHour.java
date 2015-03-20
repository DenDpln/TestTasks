package task2;

import java.io.IOException;
import java.util.Date;

/**
* Created by den on 19.03.2015.
*/
public class CleanerOneHour extends Thread{
    Date nowTime = new Date();
    @Override
    public void run() {
        while (true) {
            try {
                nowTime = new Date();
                System.out.printf("время ожидания -  " + (60000 - (System.currentTimeMillis()-JobCHMap.getCHMap().firstKey())) + "   начиная с -   " + nowTime.getMinutes() + ":" + nowTime.getSeconds() + '\n');
                Thread.sleep(60000 - (System.currentTimeMillis()-JobCHMap.getCHMap().firstKey()));
                //System.out.println("минута прошла" + "  " + nowTime.getMinutes() + ":" + nowTime.getSeconds());
                StoreCash.cleanerOnTime();
            } catch (InterruptedException ex) {
                nowTime = new Date();
               // System.out.printf("   останов --------------------" + "  " + nowTime.getMinutes() + ":" + nowTime.getSeconds() + '\n');

            }
        }
    }
}

