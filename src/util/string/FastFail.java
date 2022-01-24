package util.string;

import java.util.*;

public class FastFail {

    static void checkFastFail() {
        Hashtable<String, String> hashtable = new Hashtable();
        hashtable.put("Delhi", "India");
        hashtable.put("Moscow", "Russia");
        hashtable.put("New York", "USA");
        Iterator iteratorTemp = hashtable.keySet().iterator();
        while(iteratorTemp.hasNext()) {
            String key = (String)iteratorTemp.next();
            if(key.equals("Moscow")) {
                hashtable.remove(key);
            }
            System.out.println(hashtable.get(key) + " ") ;
        }
    }

    public static void main(String[] args) {
        checkFastFail();
    }
}
