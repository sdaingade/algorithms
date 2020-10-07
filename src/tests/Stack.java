package tests;

import java.util.Iterator;

public class Stack<T> implements Iterable<T> {
  private Node head;

  private class Node {
	  T item;
	  Node next;
  }
  
  boolean isEmpty() {
    return head == null;	  
  }
  
  void push(T item) {
	Node newNode = new Node();
	newNode.item = item;
	newNode.next = head;
	head = newNode;
  }
  
  T pop() throws Exception {
	  if (!isEmpty()) {
	    T item = head.item;
	    head = head.next;
	    return item;
	  }
	  throw new Exception("Stack is empty");
  }

  private class LinkListIterator implements Iterator<T> {
    private Node current = head;

	@Override
	public boolean hasNext() {
		return current != null;
	}

	@Override
	public T next() {
		T item = current.item;
		current = current.next;
		return item;
	}

	@Override
	public void remove() {
		/* Not Supported */
	}
  }
  
  @Override
  public Iterator<T> iterator() {
  	return new LinkListIterator();
  }

  public static void main(String[] args){
	  Stack<Integer> intStack = new Stack<Integer>();
	  try {
	    intStack.push(new Integer(10));
	    intStack.pop();
	    intStack.pop();
	  } catch(Exception e) {
		  System.out.println("Error! " + e.getMessage());
	  }
  }


}
