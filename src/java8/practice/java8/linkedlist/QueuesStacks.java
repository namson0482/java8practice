package java8.linkedlist;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.function.Consumer;

public class QueuesStacks {

    QueuesStacks() {
    }

    static void reverseQueue() {
        Queue<String> queue = new LinkedList<>();
        queue.add("1");
        queue.add("2");
        queue.add("3");
        queue.add("4");

        Stack<String> stacks = new Stack<>();
        String queueStr = "";
        while(!queue.isEmpty()) {
            String value = queue.poll();
            stacks.push(value);
            queueStr += value + " ";
        }

        String stackStr = "";
        while(!stacks.isEmpty()) {
            String value = stacks.pop();
            stackStr += value + " ";

        }
        System.out.println("Queue: " + queueStr);
        System.out.println("Stack: " + stackStr);
    }

    static void reverseQueueEx_2() {
        Queue<String> queue = new LinkedList<>();
        queue.add("1");
        queue.add("2");
        queue.add("3");
        queue.add("4");

        LinkedList linkedList = new LinkedList(queue);
        Iterator<String> iterator = linkedList.descendingIterator();
        String value = "";
        while(iterator.hasNext()) {
            value += iterator.next() + " ";
        }
        System.out.println(value);
    }

    static void reverseQueueEx_3() {
        Queue<String> queue = new LinkedList<>();
        queue.add("1");
        queue.add("2");
        queue.add("3");
        queue.add("4");

        String value = "";
        LinkedList linkedList = new LinkedList(queue);
        for(int i=linkedList.size()-1;i>=0;i--) {
            value += linkedList.get(i) + " ";
        }
        System.out.println(value);
    }

    public static void main(String[] args) {
        reverseQueueEx_3();
    }
}
