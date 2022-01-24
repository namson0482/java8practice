package java8.phuc;


import java.util.Scanner;

public class QuadraticEquation {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        //Declare variables
        double a = 0;
        double b = 0;
        double c = 0;
        double d = 0; // d stands for conditions to check
        double x1 = 0;
        double x2 = 0;
        double x3 = 0;
        //Take inputs
        System.out.println("Input the value a,b and c " +
                "for the quadratic eqaution operation");
        System.out.println("Input a: ");
        a = s.nextDouble();
        System.out.println("Input b: ");
        b = s.nextDouble();
        System.out.println("Input c: ");
        c = s.nextDouble();

        //Process inputs
        d = Math.pow(b, 2) - 4 * a * c;
        if (d > 0) {
            x1 = (-b + Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / (2 * a);
            x2 = (-b - Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / (2 * a);
            //Output results
            System.out.println("x1 =" + x1);
            System.out.println("x2 =" + x2);

            int x1Int = (int) x1;
            int x2Int = (int) x2;
            System.out.println("x1Int =" + x1Int);
            System.out.println("x2Int =" + x2Int);


        }
        else if (d == 0) {
            x3 = (-b)/(2*a);
            //Output results
            System.out.println("There is one real root at x3 ="+ x3);

            int x3AbsInt = Math.abs((int) x3);
            System.out.println("x3Int =" + x3AbsInt);

        }
        else {
            System.out.println("There is no real roots");
        }
    }
}