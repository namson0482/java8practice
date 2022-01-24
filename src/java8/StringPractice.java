package java8;

import java.util.Deque;
import java.util.LinkedList;

public class StringPractice {
	
	public static boolean bracketBalance(String input) {
		Deque<Character> queue = new LinkedList<>();
		for(char ch : input.toCharArray()) {
			if(ch == '(' || ch == '[' || ch == '{') {
				queue.push(ch);
			} else if(ch == ')' || ch == ']' || ch == '}') {
				if(!queue.isEmpty() 
						&& ((queue.peekFirst() == '(' &&ch == ')') 
						|| (queue.peekFirst() == '{' &&ch == '}') 		
						||  (queue.peekFirst() == '[' && ch == ']') )) {
					queue.pop();
				}
				else {
					return false;
				}
			}
		}
		return queue.isEmpty();
	}
	
	
	public static boolean isBalanced(String input) {
		
//		int openBracket = 0;
//		int closeBracket = 0;
//		String []arrayBracket = input.trim().split("");
//		for(int i=0;i<arrayBracket.length;i++) {
//			if(arrayBracket[i].equalsIgnoreCase(")")) {
//				if(openBracket==0) return false;
//				closeBracket++;
//			}
//			if(arrayBracket[i].equalsIgnoreCase("(")) openBracket++;
//		}
//		return openBracket == closeBracket && openBracket != 0 ? true : false;
		
		Deque<Character> deque = new LinkedList<>();
		for (char ch: input.toCharArray()) {
		    if (ch == '{' || ch == '[' || ch == '(') {
		        deque.addFirst(ch);
		    } else if (ch == '}' || ch == ']' || ch == ')') { 
		        if (!deque.isEmpty()
		            && ((deque.peekFirst() == '{' && ch == '}')
		            || (deque.peekFirst() == '[' && ch == ']')
		            || (deque.peekFirst() == '(' && ch == ')'))) {
		            deque.removeFirst();
		        } else {
		            return false;
		        }
		    }
		}
		return true;
	}
	
	public static void main(String[] args) {
//		String input = ")abc(";
		String input = "(a)";
//		String input = "(a[][])";
		System.out.println(bracketBalance(input));
	}


}
