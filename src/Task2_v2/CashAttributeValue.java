package Task2_v2;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by den on 23.03.2015.
 */
public class CashAttributeValue {
    ConcurrentHashMap<String,String> cashCHMap;
    protected CashAttributeValue(){
        cashCHMap = new ConcurrentHashMap<String,String>();
    }
    private static CashAttributeValue instance;
    protected static CashAttributeValue greatCHMap() {
        if (instance == null) {
            instance = new CashAttributeValue();
        }
        return instance;
    }

}
