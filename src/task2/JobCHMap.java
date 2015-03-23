package task2;

import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 */
public class JobCHMap {
    protected static void putCHMap(Long l, String s){
        CHMap cashMap = CHMap.greatCHMap();
        cashMap.put(l,s);
    }
    protected static TreeMap<Long, String> getCHMap(){
        CHMap cashMap = CHMap.greatCHMap();
        return cashMap.getCHMap();
    }
    protected static void removeFirst(){
        CHMap cashMap = CHMap.greatCHMap();
        cashMap.removeFirst();
    }

}