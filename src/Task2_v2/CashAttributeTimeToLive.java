package Task2_v2;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by den on 23.03.2015.
 */
public class CashAttributeTimeToLive {
    ConcurrentHashMap<String,String> cashCHMap;
    protected CashAttributeTimeToLive(){
        cashCHMap = new ConcurrentHashMap<String,String>();
    }
    private static CashAttributeTimeToLive instance;
    public static CashAttributeTimeToLive greatCHMap() {
        if (instance == null) {
            instance = new CashAttributeTimeToLive();
        }
        return instance;
    }
}
