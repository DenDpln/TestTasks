package Task2_v2;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by den on 23.03.2015.
 */
public class CashTimeToLiveAttribute {
    ConcurrentHashMap<Long,String> cashTTLA;
    protected CashTimeToLiveAttribute(){
        cashTTLA = new ConcurrentHashMap<Long,String>();
    }
    private static CashTimeToLiveAttribute instance;
    public static CashTimeToLiveAttribute greatCshTTLA() {
        if (instance == null) {
            instance = new CashTimeToLiveAttribute();
        }
        return instance;
    }
    protected void putCashTTLA(Long ttl, String attr){
        cashTTLA.put(ttl,attr);
    }
}
