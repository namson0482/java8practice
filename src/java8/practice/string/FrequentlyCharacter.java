package java8.practice.string;

import java.util.*;

public class FrequentlyCharacter {

    static void printOutCharacterFrequently(String input) {
        char character[] = input.toCharArray();
        Map<Character, Integer> frequently = new HashMap<Character, Integer>();
        for (int i = 0; i < character.length; i++) {
            if (frequently.containsKey(character[i])) {
                frequently.put(character[i], frequently.get(character[i]) + 1);
            } else {
                frequently.put(character[i], 1);
            }
        }

        Comparator<Map.Entry<Character, Integer>> valueComparator = (e1, e2) -> {
            Character c1 = e1.getKey();
            Character c2 = e2.getKey();
            Integer v1 = e1.getValue();
            Integer v2 = e2.getValue();
            if (v1 == v2) {
                return c1.compareTo(c2);
            }
            return v2.compareTo(v1);
        };

        List<Map.Entry<Character, Integer>> listOfEntries
                = new ArrayList<Map.Entry<Character, Integer>>(frequently.entrySet());
        Collections.sort(listOfEntries, valueComparator);
        listOfEntries.forEach(x-> System.out.println("Key " + x.getKey() + " and Value " + x.getValue()));

//        frequently.entrySet().stream().sorted( (e1, e2) -> {
//            Character c1 = e1.getKey();
//            Character c2 = e2.getKey();
//            Integer v1 = e1.getValue();
//            Integer v2 = e2.getValue();
//            if (v1 == v2) {
//                return c1.compareTo(c2);
//            }
//            return v2.compareTo(v1);
//        }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)).forEach( (e1, e2) -> System.out.println(e1 +" " + e2 ));
    }

    public static void main(String[] args) {
        printOutCharacterFrequently("bbaac");
    }
}
