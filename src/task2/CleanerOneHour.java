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
                long firstKeyValue;
                if (JobCHMap.getCHMap().isEmpty()){
                    firstKeyValue=0;
                }else {
                    firstKeyValue = JobCHMap.getCHMap().firstKey();
                }
                long witingTime = (60000 - (System.currentTimeMillis()-firstKeyValue));
                if (witingTime <= 0){witingTime = 60000;}
                nowTime = new Date();
                System.out.printf("время ожидания -  " + witingTime + "   начиная с -   " + nowTime.getMinutes() + ":" + nowTime.getSeconds() + '\n');
                Thread.sleep(witingTime);
            } catch (InterruptedException ex) {
                nowTime = new Date();
            } finally {
                StoreCash.cleanerOnTime();
            }
        }
    }
}