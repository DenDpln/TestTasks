package task2;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by den on 19.03.2015.
 */
public class JobCHMap {
    public static void putCHMap(String e, Long r){
        CHMap cashMap = CHMap.greatCHMap();
        cashMap.put(e,r);
    }
    public static void removeCHMap(String e){
        CHMap cashMap = CHMap.greatCHMap();
        cashMap.remove(e);
    }
    public static ConcurrentHashMap getCHMap(){
        CHMap cashMap = CHMap.greatCHMap();
       return cashMap.getCHMap();
    }
    public static Integer sizeCHMap(){
        CHMap cashMap = CHMap.greatCHMap();
        return cashMap.size();
    }

}
