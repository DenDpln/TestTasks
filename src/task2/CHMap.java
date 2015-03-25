package task2;

import java.util.Collection;
import java.util.TreeMap;

/**
 *
 */
public class CHMap {
    TreeMap<Long,String> cashCHMap;
    protected CHMap(){cashCHMap = new TreeMap<Long,String>();
    }
    private static CHMap instance;
    protected static CHMap greatCHMap() {
        if (instance == null) {
            instance = new CHMap();
        }
        return instance;
    }
    protected String put(Long timeNow, String messageNew){return cashCHMap.put(timeNow, messageNew);}
    protected TreeMap<Long,String> getCHMap(){return cashCHMap;}
    protected String removeFirst(){return cashCHMap.remove(cashCHMap.firstKey());}
    protected Collection<String> getValues(){return cashCHMap.values();}


}