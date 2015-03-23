package Task2_v2;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by den on 23.03.2015.
 */
public class CashAttributeMessages {
    ConcurrentHashMap<String,String> cashAM;
    protected CashAttributeMessages(){
        cashAM = new ConcurrentHashMap<String,String>();
    }
    private static CashAttributeMessages instance;
    protected static CashAttributeMessages greatCshAM() {
        if (instance == null) {
            instance = new CashAttributeMessages();
        }
        return instance;
    }
    protected void putCashAM(String attr, String mess){cashAM.put(attr,mess);}

}
