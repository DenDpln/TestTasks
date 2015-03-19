package task2;

import java.io.IOException;

/**
* Created by den on 19.03.2015.
*/
public class CleanerOneHour extends Thread{

    @Override
    public void run() {
        while (true) {
            try {
                System.out.printf("ждём минуту " + '\n');
                Thread.sleep(60000);
                System.out.println("минута прошла");
                System.out.println("всего сообщений    " + "   " + "size= " + JobCHMap.sizeCHMap()+ "  " +JobCHMap.getCHMap());
                StoreCash.cleanerOnTime();
            } catch (InterruptedException ex) {
                System.out.printf("   останов --------------------" + '\n');
                Thread.currentThread().run();

            }
        }
    }
}

