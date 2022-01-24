package util.string;

import java.util.HashMap;
import java.util.Map;

public class LongestSubString {
    static String getLongestSubString(String input) {
        int start = 0;
        int st = 0;
        int maxLength = 0;
        int currentLength = 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put(input.charAt(0), 0);
        int i = 1;
        for(i=1;i<input.length();i++) {
            if(!map.containsKey(input.charAt(i))) {
                map.put(input.charAt(i), i);
            } else {
                if(map.get(input.charAt(i)) >= st) {
                    currentLength = i - st;
                    if(currentLength > maxLength) {
                        start = st;
                        maxLength = currentLength;
                    }
                    st = map.get(input.charAt(i)) + 1;
                }
                map.replace(input.charAt(i), i);
            }
        }
        if(i-st >= maxLength) {
            start = st;
            maxLength = i - st;
        }
        return input.substring(start, start + maxLength);
    }

    public static void main(String[] args) {
        String input = "tiki.vnso1faikhong";
        System.out.println(getLongestSubString(input));
    }

}
