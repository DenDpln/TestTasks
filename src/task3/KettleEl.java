package task3;

/**
 * интерфейс электрического чайника с юнит-тестами
 */
interface Kettle {
    public boolean pourWater(int waterLevel);

    public boolean turnOn(boolean button, boolean canTurnOn);

    public void turnOff();

    public boolean boiled(int boilingPoint);

    public void autoTurnOff();

    public boolean buttonIsPressed(boolean button);

    public boolean Gaz();

    public void StartEnd(boolean button, boolean isPressed, int boilingPoint, int waterLevel);
}

public class KettleEl implements Kettle {

    /**
     * проверка уровня воды
     */
    public boolean pourWater(int waterLevel) {
        if (waterLevel > 0 && waterLevel < 2) {
            System.out.println("Вода есть можно включать");
            return true;
        } else {
            if (waterLevel > 2) {
                System.out.println("Воды слишком много, сработала защита");
                turnOff();
            }
        }
        return true;
    }

    /**
     * можно ли включить чайник, уровень воды больше 0 и нажата кнопка button = true
     */

    public boolean turnOn(boolean button, boolean canTurnOn) {
        if (buttonIsPressed(button) && canTurnOn) {
            System.out.println("Чайник включён, вода есть");
            return true;
        } else {
            if (!buttonIsPressed(button)) {
                System.out.println("Не нажата кнопка");
                return false;
            }
            if (!canTurnOn) {
                System.out.println("Нет воды");
            }
            return false;
        }
    }

    /**
     * чайник не закипел но нажата кнопка во время работы, принудительное выключение
     */
    public void turnOff() {
        System.out.println("Принудительное выключение.");
        System.exit(0);
    }

    /**
     * если температура воды меньше 100 , доводим до кипения
     */
    public boolean boiled(int boilingPoint) {
        if (boilingPoint < 100) {
            System.out.println("Температура меньше 100, греем дальше");
            boilingPoint = boilingPoint + 100;
            try {
                Thread.sleep(5000);
                System.out.println("Довели температуру до 100");
                autoTurnOff();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * если температура воды >= 100 автовыключение
     */

    public void autoTurnOff() {
        System.out.println("Закипел, автовыключение.");
        System.exit(0);
    }

    /**
     * проверка нажата ли кнопка включения
     */
    public boolean buttonIsPressed(boolean button) {
        if (button) {
            System.out.println("Кнопака включения нажата");
            return true;
        } else {
            System.out.println("Кнопку включения никто не нажал");
            System.exit(0);
            return false;
        }
    }

    /**
     * не используемый метод
     */
    public boolean Gaz() {
        System.out.println("Чайник загорелся на газовой плите, Вызывайте пожарных");
        return false;
    }
    /**
     * boolean button - кнопка включения
     * boolean isPressed - произвольное нажатие кнопки когда чайник включён
     * int boilingPoint - температура воды в чайнике, при 100 кипит
     * int waterLevel - уровень воды в чайнике, не включится если меньше нуля
     *
     */

    public void StartEnd(boolean button, boolean isPressed, int boilingPoint, int waterLevel) {
        if (turnOn(button, pourWater(waterLevel))) {
            if (isPressed) {
                turnOff();
            }
            if (boilingPoint >= 100) {
                autoTurnOff();
            } else {
                if (boiled(boilingPoint)) {
                    boiled(boilingPoint);
                }
            }
        }

    }
}
