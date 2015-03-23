package Task2_v2;

/**
 * Created by den on 23.03.2015.
 */
public class ProcessingCash {
    protected static long timeToLive = 60000;
    private static void messageCome(String attr,String mess,Long ttl){
        JobMap.putAttrMess(mess,attr);
        JobMap.putTTLAttr(mess,ttl);

    }
    private static void runProcessing(){
        try {
        messageCome("Отправитель", "mess1", System.currentTimeMillis());
            Thread.sleep(52);
        messageCome("Отправитель", "mess2", System.currentTimeMillis());
            Thread.sleep(60);
        messageCome("Отправитель", "mess3", System.currentTimeMillis());
            Thread.sleep(250);
        messageCome("Отправитель", "mess4", System.currentTimeMillis());
            Thread.sleep(15);
        messageCome("Отправитель", "mess5", System.currentTimeMillis());
            Thread.sleep(35);
        messageCome("Отправитель", "mess6", System.currentTimeMillis());
            Thread.sleep(10);
        messageCome("Отправитель", "mess7", System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            System.out.println("сообщение и аттрибут(отправитель)  " + CashAttributeMessages.greatCshAM().getAM());
            System.out.println("сообщени и время жизни для него  " + CashTimeToLiveAttribute.greatCshTTLA().getTTLAttr());
        }
    }

    private static void cleanToTime(){
        long currentTimeMsCheck = System.currentTimeMillis();

    }

    public static void main(String[] args) {
        runProcessing();
    }

}
