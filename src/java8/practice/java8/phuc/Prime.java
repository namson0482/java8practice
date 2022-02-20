package java8.phuc;

import java.util.Scanner;

public class Prime {
    public static String getValue() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input a number: ");
        return sc.nextLine();
    }

    public static boolean isInteger(String inputVariable) {
        try {
            Integer.parseInt(inputVariable);
            System.out.println(inputVariable + " is a valid input integer.");
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Error. " + "'" + inputVariable + "'" + " is not a valid input integer.");
            System.out.println("Please input a correct number.");
            return false;
        }
    }

    public static void checkPrime(int num) {
        int i;
        int count = 0;
        for (i = 2; i <= num / 2; i = i + 1) {
            if (num % i == 0) {
                count = count + 1;
            }
        }
        if (count == 0) {
            System.out.println(num + " is a prime number.");
        } else {
            System.out.println(num + " is not a prime number.");
        }
    }

    public static int sum(int num) {
        int x;
        int sum = 0;
        for (x = 0; x <= num; x = x + 1) {
            if (x % 2 != 0) {
                sum = sum + x;
            }
        }
        System.out.println("Sum = " + sum);
        return sum;
    }

    public static void main(String[] args) {

        while (true) {
            String para = getValue();
            if(isInteger(para)) {
                int num = Integer.parseInt(para);
                checkPrime(num);
                sum(num);
            }
        }
    }
}
