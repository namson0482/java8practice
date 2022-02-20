package java8.practice.string;

public class ReversingInteger {

    public void solution(int n) {
        int enable_print = n%10;
        while(n>0) {
//            while(n%10==0 && enable_print == 0) {
//                n = n / 10;
//                enable_print = 1;
//            }
            if(enable_print == 0 && n%10 != 0) {
                enable_print = 1;
                System.out.print(n%10);
            } else if(enable_print != 0) {
                System.out.print(n%10);
            }
            n = n/10;
        }
    }

    public static void main(String[] args) {
        ReversingInteger v = new ReversingInteger();
        v.solution(100);
    }

}
