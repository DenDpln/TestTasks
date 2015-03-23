package task3;

/**
 * Created by den on 23.03.2015.
 */
 interface Kettle {
    public boolean pourWater(int waterLevel);
    public boolean turnOn();
    public boolean turnOff();
    public boolean boiled(int boilingPoint);
    public boolean autoTurnOff(int boilingPoint);
    public boolean buttonIsPressed();
}
public class KettleEl implements Kettle{
    boolean canTurnOn = false;
    boolean turnOn = false;
    boolean batton = false;
    @Override
    public boolean pourWater(int waterLevel) {
        if (waterLevel>0) {
            canTurnOn = true;
            System.out.println("Вода есть можно включать");}
        return canTurnOn;
    }

    public boolean turnOn() {
        if (buttonIsPressed()&&canTurnOn)
        {System.out.println("Чайник включён");
         turnOn = true;}else {
            if (!buttonIsPressed()){
                System.out.println("не нажата кнопка");
                turnOn = false;
            }
            if (!canTurnOn){
                System.out.println("Нет воды");}
                turnOn = false;
        }
        return turnOn;
    }

    public boolean turnOff() {
        return true;
    }

    public boolean boiled(int boilingPoint) {
        if (boilingPoint >= 100 && turnOn()){
            return true;
        }
        return false;
    }
    public boolean autoTurnOff(int boilingPoint) {
        if (boilingPoint >= 100) {
            turnOn = false;}
        return turnOn;
    }

    public boolean buttonIsPressed() {
        batton = true;
        return batton;
    }
}
