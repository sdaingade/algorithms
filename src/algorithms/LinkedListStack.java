package algorithms;

import java.lang.Exception;

public class LinkedListStack<T> implements Stack<T> {
	private Node<T> head = null;

	public class Node<T> {
		private T value;
		private Node<T> next;
		
		public Node(T value) {
			this.value = value;
		}
		
		public void setValue(T value) {
			this.value = value;
		}
		
		public T getValue() {
			return this.value;
		}

		public void setNext(Node<T> next) {
			this.next = next;
		}

		public Node<T> getNext() {
			return next;
		}
	}
	
	@Override
	public synchronized boolean isEmpty() {
		return head == null;
	}
	
	@Override
	public synchronized void push(T value) throws Exception {
		Node<T> oldHead = head;
		head = new Node<T>(value);
		head.setNext(oldHead);
		System.out.println("Pushed " + value + " successfully.");
	}
	
	@Override
	public synchronized T pop() throws Exception {
		Node<T> oldHead = head;
		
		if (oldHead == null) {
			throw new Exception("No more items");
		}

		head = head.getNext();
		T value = oldHead.getValue();
		System.out.println("Popped " + value + " successfully.");
		return value;
	}
}
