package task2;

import java.util.Collection;
import java.util.TreeMap;

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
    protected static Collection<String> getValue(){
        CHMap cashMap = CHMap.greatCHMap();
        return cashMap.getValues();
    }

}