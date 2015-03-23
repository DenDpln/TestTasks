package Task2_v2;

/**
 * Created by den on 23.03.2015.
 */
public class ProcessingCash {
    static long timeToLive = 60000;
    private static void messageCome(String attr,String mess,Long ttl){
        JobMap.putAttrMess(mess,attr);
        JobMap.putTTLAttr(mess,ttl);

    }
    private static void runProcessing(){
        try {
        messageCome("Отправитель", "mess1", timeToLive);
            Thread.sleep(52);
        messageCome("Отправитель", "mess2", timeToLive);
            Thread.sleep(60);
        messageCome("Отправитель", "mess3", timeToLive);
            Thread.sleep(250);
        messageCome("Отправитель", "mess4", timeToLive);
            Thread.sleep(15);
        messageCome("Отправитель", "mess5", timeToLive);
            Thread.sleep(35);
        messageCome("Отправитель", "mess6", timeToLive);
            Thread.sleep(10);
        messageCome("Отправитель", "mess7", timeToLive);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            System.out.println("аттрибут и сообщение  " + CashAttributeMessages.greatCshAM().getAM());
            System.out.println("аттрибут и время жизни для него  " + CashTimeToLiveAttribute.greatCshTTLA().getTTLAttr());
        }
    }

    public static void main(String[] args) {
        runProcessing();
    }

}
