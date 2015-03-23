package Task2_v2;

/**
 * Created by den on 23.03.2015.
 */
public class JobMap {
    protected static void putAttrMess(String attr,String mess){
        CashAttributeMessages cashAttributeMessagesshAttrMess = CashAttributeMessages.greatCshAM();
        cashAttributeMessagesshAttrMess.putCashAM(attr,mess);
    }
    protected static void putTTLAttr(Long ttl,String attr){
        CashTimeToLiveAttribute cashTimeToLiveAttribute = CashTimeToLiveAttribute.greatCshTTLA();
        cashTimeToLiveAttribute.putCashTTLA(ttl, attr);
    }
}
