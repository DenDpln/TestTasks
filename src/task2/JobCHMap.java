package task2;

import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by den on 19.03.2015.
 */
public class JobCHMap {
    protected static void putCHMap(Long l, String s){
        CHMap cashMap = CHMap.greatCHMap();
        cashMap.put(l,s);
    }
    protected static void removeCHMap(Long e){
        CHMap cashMap = CHMap.greatCHMap();
        cashMap.remove(e);
    }
    protected static TreeMap<Long, String> getCHMap(){
        CHMap cashMap = CHMap.greatCHMap();
        return cashMap.getCHMap();
    }
    protected static Integer sizeCHMap(){
        CHMap cashMap = CHMap.greatCHMap();
        return cashMap.size();
    }
    protected static String get(Long l){
        CHMap cashMap = CHMap.greatCHMap();
        return cashMap.get(l);
    }
    protected static Long firstKey(){
        CHMap cashMap = new CHMap();
        return cashMap.firstKey();
    }
    protected static void removeFirst(){
        CHMap cashMap = CHMap.greatCHMap();
        cashMap.removeFirst();
    }

}