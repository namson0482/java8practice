package java8.hashmap;

import java.util.*;

public class Sorted {

    static void sorted(String input) {
        Map<Character, Integer> maps = new HashMap<>();
        for(int i=0;i<input.length();i++) {
            if(maps.containsKey(input.charAt(i))) {
                maps.replace(input.charAt(i), maps.get(input.charAt(i)) + 1);
            } else {
                maps.put(input.charAt(i), 1);
            }
        }

        List<Map.Entry<Character, Integer>> list = new ArrayList<>(maps.entrySet());
        Collections.sort(list, (e1, e2) -> {
            if(e1.getValue().intValue() == e2.getValue().intValue()) {
                return e1.getKey().compareTo(e2.getKey());
            }
            return e2.getValue().compareTo(e1.getValue());
        });

        for (Map.Entry<Character, Integer> integerEntry : list) {
            System.out.println("Key " + integerEntry.getKey() + " Value " + integerEntry.getValue());
        }
    }

    static String getInputString() {
        System.out.println("Enter value: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return input.trim();
    }

    public static void main(String[] args) {
        String input = getInputString();
        sorted(input);
    }
}
