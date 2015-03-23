package task2;

import java.util.TreeMap;

/**
 * Created by den on 19.03.2015.
 */
public class CHMap {
    TreeMap<Long,String> cashCHMap;
    protected CHMap(){
        cashCHMap = new TreeMap<Long,String>();
    }
    private static CHMap instance;
    protected static CHMap greatCHMap() {
        if (instance == null) {
            instance = new CHMap();
        }
        return instance;
    }
    protected String put(Long timeNow, String messageNew){return cashCHMap.put(timeNow, messageNew);}
    protected String remove(Long timeNow){return cashCHMap.remove(timeNow);}
    protected String get(Long timeNow){return cashCHMap.get(timeNow);}
    protected Integer size(){return cashCHMap.size();}
    protected TreeMap<Long,String> getCHMap(){return cashCHMap;}
    protected Long firstKey(){return cashCHMap.firstKey();}
    protected String removeFirst(){return cashCHMap.remove(cashCHMap.firstKey());
    }

}