package tests;

public class StackOfObjects {
	private Node head;

	private class Node {
		Object item;
		Node next;
	}
	
	public boolean isEmpty() {
	  return head == null;
	}

	public void push(Object item) {
		Node newNode = new Node();
		newNode.item = item;
   	    newNode.next = head;
		head = newNode;
	}

	Object Pop() {
		Object item = head.item;
		head = head.next;
		return item;
	}

  public static void main(String[] args) {
	  StackOfObjects stack = new StackOfObjects();
	  Integer i = 10;
	  Integer j = 20;
	  
	  stack.push(i);
	  stack.push(j);
	  Integer k = (Integer) stack.Pop();
	  System.out.println("Popped" + k);
  }
}

