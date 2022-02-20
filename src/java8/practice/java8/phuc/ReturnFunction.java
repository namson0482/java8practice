package java8.phuc;

public class ReturnFunction {

    public static int returnInteger() {
        return 2;
    }

    public static float returnFloat() {
        return 2.1f;
    }

    public static double returnDouble() {
        return 5.2d;
    }

    public static String returnString() {
        return "String";
    }

    public static void nothingReturn(int value) {

        System.out.println("Line 0");
        if(value % 2 == 0) {
            return;
        }
        System.out.println("Finished !!!");
    }

    public static void main(String[] args) {
        int value = returnInteger();
        System.out.println(String.format("%d", value));

        float fValue = returnFloat();
        System.out.println(String.format("%f", fValue));

        double dValue = returnDouble();
        System.out.println(String.format("%f", dValue));

        String sValue = returnString();
        System.out.println(String.format("%s", sValue));

        nothingReturn(2);
    }
}
