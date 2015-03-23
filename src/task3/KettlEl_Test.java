package task3;

/**
 * Created by den on 23.03.2015.
 */
import junit.framework.TestCase;
public class KettlEl_Test extends TestCase {

    public static void testKettle(){
        KettleEl kettleEl = new KettleEl();
        kettleEl.autoTurnOff(100);
        kettleEl.pourWater(1);
        kettleEl.boiled(110);
        kettleEl.turnOn();
    }

    public static void main(String[] args) {
         testKettle();
    }

}
