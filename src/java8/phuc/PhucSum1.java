package java8.phuc;

import java.util.Scanner;

public class PhucSum1 {
    public static String getValue(String c) {
        Scanner sc = new Scanner(System.in);
        System.out.print(c);
        return sc.nextLine();
    }

    public static String isInteger(String inputVariable) {
        try {
            Integer.parseInt(inputVariable);
            System.out.println(inputVariable + " is a valid number.");
            return "aNumber";
        } catch (NumberFormatException e) {
            System.out.println("Error. " + "'" + inputVariable + "'" + " is not a valid input integer.");
            System.out.println("Please input a correct number.");
            return "notANumber";
        }
    }

    public static String isZero(String inputVariable) {
        int i = Integer.parseInt(inputVariable);
        if (i == 0) {
            return "isZero";
        } else {
            return "isNotZero";
        }
    }

    public static int sum1(int a, int b) {
        int sum = a + b;
        System.out.println("Sum = " + sum);
        return sum;
    }

    public static void calculateSum() {
        int number_1 = -1;
        int number_2 = -1;
        boolean exit = false;
        String a, b;
        while (true) {

            // Let user enter value for a
            while(true) {
                a = getValue("Please input value for a: ");
                if(isInteger(a).equalsIgnoreCase("aNumber") ) {
                    number_1 = Integer.parseInt(a);
                    break;
                } else {
                    if(a.equalsIgnoreCase("exit") || a.equalsIgnoreCase("thoat")) {
                        System.out.println("Good bye. See you again !!!");
                        return;
                    }
                }
            }

            // Let user enter value for b
            while(true) {
                b = getValue("Please input value for b: ");
                if(isInteger(b).equalsIgnoreCase("aNumber") ) {
                    number_2 = Integer.parseInt(b);
                    break;
                } else {
                    if(b.equalsIgnoreCase("exit") || b.equalsIgnoreCase("thoat")) {
                        System.out.println("Good bye. See you again !!!");
                        return;
                    }
                }
            }
            sum1(number_1, number_2);
        }
    }

    public static void main(String[] args) {
        calculateSum();
    }
}


