package java8.hashmap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapSort {

    public static <K, V extends Comparable<V>> Map<K, V> valueSort(final Map<K, V> map) {
        Comparator<K> valueComparator = (k1, k2) -> {
            Integer value1 = (Integer)map.get(k1);
            Integer value2 = (Integer)map.get(k2);
            if(value1.intValue() == value2.intValue()) {
                String key1 = (String)k1;
                String key2 = (String)k2;
                return key1.compareTo(key2);
            }
            return value2.compareTo(value1);

        };
        Map<K, V> sorted = new TreeMap<K, V>(valueComparator);
        sorted.putAll(map);
        return sorted;
    }

    public static void main(String[] args) {
        Map<String, Integer> hashMap = new HashMap<String, Integer>();
        hashMap.put("c", 3);
        hashMap.put("b", 1);
        hashMap.put("a", 3);

        hashMap = valueSort(hashMap);
        hashMap.entrySet().forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));
    }
}



