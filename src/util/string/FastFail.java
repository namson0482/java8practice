package util.string;

import java.util.*;

public class FastFail {

    static void checkFastFail() {
        HashMap<String, String> hashtable = new HashMap();
        hashtable.put("Delhi", "India");
        hashtable.put("Moscow", "Russia");
        hashtable.put("New York", "USA");
        Iterator iteratorTemp = hashtable.keySet().iterator();
        while(iteratorTemp.hasNext()) {
            String key = (String)iteratorTemp.next();
            System.out.println(hashtable.get(key) + " ") ;
            hashtable.remove(key);
        }
    }

    void hashMapConcurrentException() {
        HashMap map = new HashMap();
        map.put("Delhi", "India");
        map.put("Moscow", "Russia");
        map.put("New York", "USA");
        Iterator iteratorTemp = map.keySet().iterator();
        while(iteratorTemp.hasNext()) {
            try {
                String key = (String)iteratorTemp.next();
                System.out.println(map.get(key) + " ") ;
                // it throws a ConcurrentModificationException
                map.remove(key);
            } catch (ConcurrentModificationException e) {
                System.out.println("Exception: ConcurrentModificationException");
                break;
            }

        }
    }

    void hashMapNormal() {
        HashMap map = new HashMap();
        map.put("Delhi", "India");
        map.put("Moscow", "Russia");
        map.put("New York", "USA");
        Iterator iteratorTemp = map.keySet().iterator();
        while(iteratorTemp.hasNext()) {
            String key = (String)iteratorTemp.next();
            System.out.println(map.get(key) + " ") ;
        }
    }


    void hashTable() {
        Hashtable hashtable = new Hashtable();
        hashtable.put("Delhi", "India");
        hashtable.put("Moscow", "Russia");
        hashtable.put("New York", "USA");
        Enumeration<String> e = hashtable.keys();
        while (e.hasMoreElements()) {
            // Printing the current element
            String key = e.nextElement();
            if(key.equalsIgnoreCase("Delhi")) {
                hashtable.remove(key);
                continue;
            }
            System.out.println(key);
        }
    }

    /**
     * This function proceed a string. traverse a hashtable and print all elements
     * It removes an element with key equal Delhi
     */
    static void showFastFailExample() {
        FastFail fastFail = new FastFail();
        fastFail.hashMapNormal();
        fastFail.hashMapConcurrentException();
        System.out.println("******************************************************************");
        System.out.println("***********************Hashtable example:*************************");
        System.out.println("******************************************************************");
        fastFail.hashTable();
    }

    public static void main(String[] args) {
        showFastFailExample();
    }
}
