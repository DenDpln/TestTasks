package task3;

/**
 * Created by den on 23.03.2015.
 */
import junit.framework.TestCase;
public class KettlEl_Test extends TestCase {

    public static void testKettle(){
        KettleEl kettleEl = new KettleEl();
        kettleEl.autoTurnOff(100);
        kettleEl.pourWater(0);
        kettleEl.boiled(90);
    }

    public static void main(String[] args) {
         testKettle();
    }

}
