package task2;

import java.io.IOException;
import java.util.Date;

/**
 *
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
                long witingTime = (StoreCash.ttl - (System.currentTimeMillis()-firstKeyValue));
                if (witingTime <= 0){witingTime = StoreCash.ttl;}
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