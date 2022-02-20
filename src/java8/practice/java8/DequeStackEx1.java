package java8;

import java.util.Deque;
import java.util.LinkedList;

public class DequeStackEx1 {

  public static void main(String[] args) {
      // Create a Deque to use as a Stack.
      Deque<String> stackOfCards = new LinkedList<>();

      // Pushing new items to the Stack
      stackOfCards.push("Jack");
      stackOfCards.push("Queen");
      stackOfCards.push("King");
      stackOfCards.push("Ace");

      System.out.println("Stack => " + stackOfCards);
      System.out.println();

      // Popping items from the Stack
      String cardAtTop = stackOfCards.pop();  // Throws NoSuchElementException if the stack is empty
      System.out.println("Stack.pop() => " + cardAtTop);
      System.out.println("Current Stack => " + stackOfCards);
      System.out.println();

      // Get the item at the top of the stack without removing it
      cardAtTop = stackOfCards.peek();
      System.out.println("Stack.peek() => " + cardAtTop);
      System.out.println("Current Stack => " + stackOfCards);
  }
}