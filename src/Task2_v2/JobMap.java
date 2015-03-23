package Task2_v2;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by den on 23.03.2015.
 */
public class JobMap {
    protected static void putAttrMess(String mess,String attr){
        CashAttributeMessages cashAttributeMessages = CashAttributeMessages.greatCshAM();
        cashAttributeMessages.putCashAM(mess,attr);
    }
    protected static void putTTLAttr(String mess, Long ttl){
        CashTimeToLiveAttribute cashTimeToLiveAttribute = CashTimeToLiveAttribute.greatCshTTLA();
        cashTimeToLiveAttribute.putCashTTLA(mess, ttl);
    }
//    protected static void messageCome(String attr,String mess,Long ttl){
//        CashAttributeMessages cashAttributeMessages = CashAttributeMessages.greatCshAM();
//        cashAttributeMessages.putCashAM(attr,mess);
//
//        CashTimeToLiveAttribute cashTimeToLiveAttribute = CashTimeToLiveAttribute.greatCshTTLA();
//        cashTimeToLiveAttribute.putCashTTLA(ttl, attr);
//    }
    protected ConcurrentHashMap<String,String> getAttrMess(){
        CashAttributeMessages cashAttributeMessages = new CashAttributeMessages();
        return cashAttributeMessages.getAM();
    }
    protected ConcurrentHashMap<String, Long> getTTLAttr(String mess, Long ttl){
        CashTimeToLiveAttribute cashTimeToLiveAttribute = new CashTimeToLiveAttribute();
        return cashTimeToLiveAttribute.getTTLAttr();
    }
}
