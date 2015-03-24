package task3;

/**
 * Created by den on 23.03.2015.
 */
import junit.framework.TestCase;
public class KettlEl_Test extends TestCase {


    /*
    тест 1: кнопка включения нажата, кнопку включения нажали один раз, температура воды меньше 100, воды 2 литра
     */

    public static void testKettle1(){
        Kettle kettleEl = new KettleEl();
        kettleEl.StartEnd(true,false,60,2);
       }

    /*
   тест 2: кнопка включения нажата, кнопку включения нажали один раз, температура воды 100, воды 2 литра
    */
    public static void testKettle2(){
        Kettle kettleEl = new KettleEl();
        kettleEl.StartEnd(true,false,100,2);
    }
    /*
 тест 3: кнопка включения не нажата
  */
    public static void testKettle3(){
        Kettle kettleEl = new KettleEl();
        kettleEl.StartEnd(false,false,100,2);
    }

    /*
 тест 4: кнопка включения нажата, кнопку включения нажали ещё раз, температура воды 100, воды 2 литра
  */
    public static void testKettle4(){
        Kettle kettleEl = new KettleEl();
        kettleEl.StartEnd(true,true,100,2);
    }

    /*
тест 4: кнопка включения нажата, кнопку включения нажали ещё раз, температура воды 100, воды 5 литров
*/
    public static void testKettle5(){
        Kettle kettleEl = new KettleEl();
        kettleEl.StartEnd(true,true,100,5);
    }

    /*
    * тест4: метод Gaz() для чайников другого типа
     */
    public static void testKettle6(){
        Kettle kettleEl = new KettleEl();
        kettleEl.Gaz();

    }

    public static void main(String[] args) {
         testKettle6();
    }

}
