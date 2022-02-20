package java8.hashmap;

import java.util.*;

public class HashMapSort {

    static void sortHashMap() {
        Map<Character, Integer> map = new HashMap<>();
        map.put('a', 3);
        map.put('c', 2);
        map.put('b', 1);
        map.put('d', 3);

        List<Map.Entry<Character, Integer>> listEntries = new ArrayList<>(map.entrySet());
        Collections.sort(listEntries, (e1, e2) -> {
            if (e1.getValue() == e2.getValue()) {
                return e1.getKey().compareTo(e2.getKey());
            }
            return e2.getValue().compareTo(e1.getValue());
        });
        listEntries.forEach(x -> System.out.println("Key " + x.getKey() + " and Value " + x.getValue()));
    }

    public static void main(String[] args) {
        sortHashMap();
    }
}
