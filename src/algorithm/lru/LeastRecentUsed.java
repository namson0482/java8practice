package algorithm.lru;

import java.util.*;

public class LeastRecentUsed {
    LinkedHashMap<String, String> cache;
    int capacity;
    LeastRecentUsed(int capacity) {
        cache = new LinkedHashMap<>();
        this.capacity = capacity;
    }

    public boolean get(String key) {
        if(!cache.containsKey(key)) return false;
        String value = cache.get(key);
        cache.remove(key);
        cache.put(key, value);
        return true;
    }

    public void put(String key, String value) {
        if(capacity == 0) return;
        if(!get(key)) {
            if (cache.size() == capacity) {
                String firstKey = cache.keySet().iterator().next();
                cache.remove(firstKey);
            }
            cache.put(key, value);
        }
    }

    public void displayOne() {

        System.out.println("");
        LinkedList<String> list = new LinkedList<>(cache.keySet());
        Iterator<String> itr = list.descendingIterator();
        while(itr.hasNext()) {
            String key = itr.next();
            System.out.print(cache.get(key) + " ");
        }
    }

    public static void main(String[] args) {
        LeastRecentUsed lru = new LeastRecentUsed(3);
        lru.put("1", "1");
        lru.put("2", "2");
        lru.put("3", "3");
        lru.displayOne();
//        lru.put("2", "2");
//        lru.displayOne();
    }
}
