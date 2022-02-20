package java8.practice.algorithm.lru;

import java.util.*;

public class JavaQueue {

    Deque<String> queue;
    LinkedHashMap<String, String> cache;

    public JavaQueue() {
        queue = new LinkedList();
        cache = new LinkedHashMap<String, String>();
    }

    public void fifo() {
        System.out.println("");
        queue.add("4");
        queue.add("5");
        queue.add("6");
        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + " ");
        }

        System.out.println("");
        cache.put("1", "1");
        cache.put("2", "2");
        cache.put("3", "3");
        cache.put("4", "4");
        LinkedList linkedList = new LinkedList(cache.keySet());
        Iterator<String> iterator = linkedList.descendingIterator();
        while(iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }

    /**
     * Last in First out
     */
    public void lifo() {
        System.out.println("");
        queue.push("1");
        queue.push("2");
        queue.push("3");
        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + " ");
        }

    }

    public static void main(String[] args) {
        JavaQueue java = new JavaQueue();
//        java.lifo();
        java.fifo();
    }
}
