package java8.practice.algorithm.arraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ArrayListExample {

    ArrayListExample() {

    }

    static void check() {
        List<Integer> listTemp = new ArrayList<>();
        listTemp.add(1);
        listTemp.add(5);
        listTemp.add(2);
        Collections.sort(listTemp);
        Collections.sort(listTemp, Comparator.reverseOrder());
        listTemp.forEach(System.out::println);
    }

    public static void main(String[] args) {
        check();
    }
}
