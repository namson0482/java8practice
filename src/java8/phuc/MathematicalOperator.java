package java8.phuc;

import java.util.Scanner;

public class MathematicalOperator {

    /**
     * @input Give string value
     * @return true if input value is Integer, else return false
     */
    static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Get input value from keyboard
     * @return String value is entered by user
     */
    static String getInputValue(String label) {
        again:
        while(true) {
            System.out.print(label);
            Scanner scanner = new Scanner(System.in);
            String value = scanner.nextLine();
            if(isInteger(value)) {
                return value;
            }
            System.out.println("Please enter integer value!!!");
            continue again;
        }
    }

    static int sum(int a, int b) {
        return a+b;
    }

    static int multi(int a, int b) {
        return a*b;
    }

    public static void main(String[] args) {
        int a, b;
        a = Integer.parseInt(getInputValue("Please enter value for a: "));
        b = Integer.parseInt(getInputValue("Please enter value for b: "));
        int c = sum(a, b);
        System.out.println(String.format("Tong cua 2 so a va b la: %d", c));
        //Hai dong code 50 va 51 co the viet tat la
        //System.out.println(String.format("Tong cua 2 so a va b la: %d", sum(a, b)));
    }
}
