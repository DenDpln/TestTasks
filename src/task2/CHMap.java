package task2;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by den on 19.03.2015.
 */
public class CHMap {
    ConcurrentHashMap<String,Long> cashCHMap;
    protected CHMap(){
        cashCHMap = new ConcurrentHashMap<String, Long>();
    }
    private static CHMap instance;
    public static CHMap greatCHMap() {
        if (instance == null) {
            instance = new CHMap();
        }
        return instance;
    }
    public Long put(String messageNew, Long timeNow){return cashCHMap.put(messageNew, timeNow);}
    public Long remove(String messageNew){return cashCHMap.remove(messageNew);}
    public Long get(String messageNew){return cashCHMap.get(messageNew);}
    public Integer size(){return cashCHMap.size();}
    public ConcurrentHashMap<String,Long> getCHMap(){return cashCHMap;}

}

