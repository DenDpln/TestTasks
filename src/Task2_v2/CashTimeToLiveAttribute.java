package Task2_v2;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by den on 23.03.2015.
 */
public class CashTimeToLiveAttribute {
    ConcurrentHashMap<String,Long> cashTTLA;
    protected CashTimeToLiveAttribute(){
        cashTTLA = new ConcurrentHashMap<String,Long>();
    }
    private static CashTimeToLiveAttribute instance;
    public static CashTimeToLiveAttribute greatCshTTLA() {
        if (instance == null) {
            instance = new CashTimeToLiveAttribute();
        }
        return instance;
    }
    protected void putCashTTLA(String mess, Long ttl){cashTTLA.put(mess, ttl);}
    protected ConcurrentHashMap<String,Long> getTTLAttr(){return cashTTLA;}
}
