package task2;

import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by den on 19.03.2015.
 */
public class JobCHMap {
    public static void putCHMap(Long l, String s){
        CHMap cashMap = CHMap.greatCHMap();
        cashMap.put(l,s);
    }
    public static void removeCHMap(Long e){
        CHMap cashMap = CHMap.greatCHMap();
        cashMap.remove(e);
    }
    public static TreeMap<Long, String> getCHMap(){
        CHMap cashMap = CHMap.greatCHMap();
        return cashMap.getCHMap();
    }
    public static Integer sizeCHMap(){
        CHMap cashMap = CHMap.greatCHMap();
        return cashMap.size();
    }
    public static String get(Long l){
        CHMap cashMap = CHMap.greatCHMap();
        return cashMap.get(l);
    }
    public static Long firstKey(){
        CHMap cashMap = new CHMap();
        return cashMap.firstKey();
    }
    public static void removeFirst(){
        CHMap cashMap = CHMap.greatCHMap();
        cashMap.removeFirst();
    }

}