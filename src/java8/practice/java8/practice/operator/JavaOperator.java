package java8.practice.operator;

import java.util.Scanner;

public class JavaOperator {

    static void divide() {
        int result = 5/2;
        System.out.println("Take 5 divide 2 = " + result);
    }

    static void multiply() {
        int result = 2*3;
        System.out.println("Take 2 multiply 3 = " + result);
    }

    static void plus() {
        int result = 2+3;
        System.out.println("Take 2 plus 3 = " + result);
    }

    static void minus() {
        int result = 6-1;
        System.out.println("Take 6 minus 1 = " + result);
    }

    static String getInputFromKeyboard() {

        System.out.print("Option: ");
        String value = null;
        Scanner sc= new Scanner(System.in);
        while(value == null || value.equalsIgnoreCase("")) {
            value = sc.nextLine();
            value = value.trim();
        }
        return value;
    }

    public static void main(String[] args) {
        System.out.println("Please choose one option below: ");
        System.out.println("1. Take 5 divide 2");
        System.out.println("2. Take 2 multiply 3");
        System.out.println("3. Take 2 plus 3");
        System.out.println("4. Take 2 plus 3");
        System.out.println("5. Exit");

        OUTER: while(true) {
            String input = getInputFromKeyboard();
            switch(input) {
                case "1":
                    divide();
                    break;
                case "2":
                    multiply();
                    break;
                case "3":
                    plus();
                    break;
                case "4":
                    minus();
                    break ;
                case "5":
                    break OUTER;
                default:
                    System.out.println("No option above is chose! Please select again");
                    continue OUTER;
            }
        }
    }
}
