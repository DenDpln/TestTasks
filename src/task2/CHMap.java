package task2;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by den on 19.03.2015.
 */
public class CHMap {
    ConcurrentHashMap<String,Long> cashMap;
    private CHMap(){
        cashMap = new ConcurrentHashMap<String, Long>();
    }
    private static ConcurrentHashMap instance;
    public static ConcurrentHashMap greatCHMap() {
        if (instance == null) {
            instance = new ConcurrentHashMap();
        }
        return instance;
    }
    public Long put(String messageNew, Long timeNow){return cashMap.put(messageNew, timeNow);}
    public Long remove(String messageNew){return cashMap.remove(messageNew);}
}
