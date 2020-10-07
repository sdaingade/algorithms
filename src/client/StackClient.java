package client;

import algorithms.Stack;
import algorithms.LinkedListStack;
import algorithms.ArrayStack;

public class StackClient {

	public static void main(String[] args) {
		Stack<String> list = new LinkedListStack<String>();
		try {
			list.push("Swapnil");
			list.push("Daingade");

			list.pop();
			list.pop();
		} catch (Exception e) {
			e.printStackTrace();
		}

		Stack<String> list2 = new ArrayStack<String>(String.class, 5);
		try {
			list2.push("Swapnil");
			list2.push("Daingade");

			list2.pop();
			list2.pop();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
}
