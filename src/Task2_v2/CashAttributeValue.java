package Task2_v2;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by den on 23.03.2015.
 */
public class CashAttributeValue {
    ConcurrentHashMap<String,String> cashAV;
    protected CashAttributeValue(){
        cashAV = new ConcurrentHashMap<String,String>();
    }
    private static CashAttributeValue instance;
    protected static CashAttributeValue greatCshAV() {
        if (instance == null) {
            instance = new CashAttributeValue();
        }
        return instance;
    }
    protected void putCashAV(String attr, String val){
        cashAV.put(attr,val);
    }

}
