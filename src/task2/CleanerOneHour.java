package task2;

import java.io.IOException;

/**
* Created by den on 19.03.2015.
*/
public class CleanerOneHour extends Thread{

    @Override
    public void run() {
       // while (!Thread.currentThread().isInterrupted()) {
            try {
                System.out.printf("con nachalo ");
                Thread.sleep(10000);
                System.out.println("zapusk cleaner");

            } catch (InterruptedException ex) {
                System.out.printf(" ostanov ");
                Thread.currentThread().run();

            }
        }
    }
//}

