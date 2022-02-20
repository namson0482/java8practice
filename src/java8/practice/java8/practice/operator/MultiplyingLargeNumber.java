package java8.practice.operator;

public class MultiplyingLargeNumber {
    // Function to compute num (mod a)
    static int mod(String num, int a) {

        // Initialize result
        int res = 0;

        // One by one process all digits of 'num'
        for (int i = 0; i < num.length(); i++)
            res = (res * 10 + (int) num.charAt(i) - '0') % a;

        return res;
    }

    // Driver program
    public static void main(String[] args) {

        String num = "1231676767867231231325345324242342334242343242348";

        System.out.println(mod(num, 10));
    }
}
