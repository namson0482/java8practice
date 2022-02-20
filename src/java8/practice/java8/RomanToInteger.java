package java8;

import java.util.*;
import java.util.stream.Collectors;

enum RomanNumeral {
    I(1, "I"), IV(4, "IV"), V(5, "V"), IX(9, "IX"), X(10, "X"),
    XL(40, "XL"), L(50, "L"), XC(90, "XC"), C(100, "C"),
    CD(400, "CD"), D(500, "D"), CM(900, "CM"), M(1000, "M");

    int value;
    String description;

    RomanNumeral(int i, String description) {
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return this.description;
    }


    public static List<RomanNumeral> getReverseSortedValues() {
        return Arrays.stream(values())
                .sorted(Comparator.comparing((RomanNumeral e) -> e.value).reversed())
                .collect(Collectors.toList());
    }

}

public class RomanToInteger {

    static Map<Character, Integer> mapNumber = new HashMap<>();

    static {
        mapNumber.put('I', 1);
        mapNumber.put('I', 1);
        mapNumber.put('V', 5);
        mapNumber.put('X', 10);
        mapNumber.put('L', 50);
        mapNumber.put('C', 100);
        mapNumber.put('D', 500);
        mapNumber.put('M', 1000);
    }

    static int romanToInteger(String roman) {

        Map<Character, Integer> numbersMap = new HashMap<>();
        numbersMap.put('I', 1);
        numbersMap.put('V', 5);
        numbersMap.put('X', 10);
        numbersMap.put('L', 50);
        numbersMap.put('C', 100);
        numbersMap.put('D', 500);
        numbersMap.put('M', 1000);
        int result = 0;
        for (int i = 0; i < roman.length(); i++) {
            char ch = roman.charAt(i);      // Current Roman Character
            //Case 1
            if (i > 0 && numbersMap.get(ch) > numbersMap.get(roman.charAt(i - 1))) {
                result += numbersMap.get(ch) - 2 * numbersMap.get(roman.charAt(i - 1));
            }
            // Case 2: just add the corresponding number to result.
            else
                result += numbersMap.get(ch);
        }

        return result;
    }

    static int toInteger(String input) {
        Map<Character, Integer> numbersMap = new HashMap<>();
        numbersMap.put('I', 1);
        numbersMap.put('V', 5);
        numbersMap.put('X', 10);
        numbersMap.put('L', 50);
        numbersMap.put('C', 100);
        numbersMap.put('D', 500);
        numbersMap.put('M', 1000);
        int result = 0;
        input = input.toUpperCase();
        for(int i=0;i<input.length();i++) {
            if(i != input.length()-1 && numbersMap.get(input.charAt(i)) < numbersMap.get(input.charAt(i + 1))) {
                result += numbersMap.get(input.charAt(i + 1)) - numbersMap.get(input.charAt(i));
                i++;
            } else {
                result += numbersMap.get(input.charAt(i));
            }
         }
        return result;

    }

    static int toIntegerRecursive(String input) {
        if(input.length() == 0) return 0;
        if(input.length() == 1) return mapNumber.get(input.charAt(0));


        char c1 = input.substring(0, 1).charAt(0);
        char c2 = input.substring(1, 2).charAt(0);
        int result = 0;
        int index = 1;
        if(mapNumber.get(c1) >= mapNumber.get(c2)) {
            result = mapNumber.get(c1);
        } else {
            result = mapNumber.get(c2) - mapNumber.get(c1);
            index = 2;
        }
        return result + toIntegerRecursive(input.substring(index));
    }

    public static void main(String args[]) {
        String romanNumber = "MMMDCCXXIV";
        int result = toInteger(romanNumber);
        System.out.println("The Roman Number is: " + result);

        // we take input as a String
//        String romanNumber = "MCMXCIV";
//        int result = romanToInteger(romanNumber);
//
//        System.out.println("The Roman Number is: " + romanNumber);
//        System.out.println("Its Integer Value is: " + result);
//
//        System.out.println();
//
////        romanNumber = "DCCXCIX";
//        romanNumber = "MCMIV";
//        result = romanToInteger(romanNumber);
//
//        System.out.println("The Roman Number is: " + romanNumber);
//        System.out.println("Its Integer Value is: " + result);
    }

}
 