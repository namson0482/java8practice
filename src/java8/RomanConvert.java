package java8;

// Program to convert Roman
// Numerals to Numbers
import java.util.Map;
import java.util.HashMap;

class RomanConvert {

    private static final Map<Character,
            Integer> roman = new HashMap<Character,
            Integer>()
    {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    // This function returns value
// of a Roman symbol
    private static int romanToInt(String s)
    {
        int sum = 0;
        int n = s.length();

        for(int i = 0; i < n; i++)
        {

            // If present value is less than next value,
            // subtract present from next value and add the
            // resultant to the sum variable.
            if (i != n - 1 && roman.get(s.charAt(i)) <
                    roman.get(s.charAt(i + 1)))
            {
                sum += roman.get(s.charAt(i + 1)) -
                        roman.get(s.charAt(i));
                i++;
            }
            else
            {
                sum += roman.get(s.charAt(i));
            }
        }
        return sum;
    }

    // Driver Code
    public static void main(String[] args)
    {

        // Considering inputs given are valid
        String input = "MCMIV";

        System.out.print("Integer form of Roman Numeral is " +
                romanToInt(input));
    }
}

// This code is contributed by rahuldevgarg
