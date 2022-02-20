package java8.practice.algorithm.arraylist;

import java.util.Scanner;

public class ArrayExample {

    static int []array;
    static int length;

    public static void enterArrayValue() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Array Length: ");
        String value = scanner.nextLine();
        length = Integer.parseInt(value);
        array = new int[length];
        for(int i=0;i<array.length;i++) {
            System.out.print(String.format("Enter value for element with index %d: ", i));
            value = scanner.nextLine();
            array[i] = Integer.parseInt(value);
        }

        System.out.println("");
        System.out.print("Array have the values: ");
        for(int i=0;i<array.length;i++) {
            System.out.print(array[i] + " ");
        }
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        enterArrayValue();
        int [][]a;
        a = new int[2][2];
        a[0][0] = 1;
        a[0][1] = 2;
        a[1][0] = 3;
        a[1][1] = 4;
        System.out.println();
        for(int i=0;i<2;i++) {
            for(int j=0;j<2;j++)
                System.out.print(a[i][j] + " ");
            System.out.println();
        }

     }

}
