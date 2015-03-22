package task2;

import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by den on 19.03.2015.
 */
public class CHMap {
    TreeMap<Long,String> cashCHMap;
    protected CHMap(){
        cashCHMap = new TreeMap<Long,String>();
    }
    private static CHMap instance;
    public static CHMap greatCHMap() {
        if (instance == null) {
            instance = new CHMap();
        }
        return instance;
    }
    public String put(Long timeNow, String messageNew){return cashCHMap.put(timeNow, messageNew);}
    public String remove(Long timeNow){return cashCHMap.remove(timeNow);}
    public String get(Long timeNow){return cashCHMap.get(timeNow);}
    public Integer size(){return cashCHMap.size();}
    public TreeMap<Long,String> getCHMap(){return cashCHMap;}
    public Long firstKey(){return cashCHMap.firstKey();}
    public String removeFirst(){
        return cashCHMap.remove(cashCHMap.firstKey());
    }

}