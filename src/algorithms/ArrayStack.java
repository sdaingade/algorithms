package algorithms;

import java.lang.reflect.Array;

import algorithms.Stack;

public class ArrayStack<T> implements Stack<T> {

	private T[] array;
	private int index = 0; // The position at which index is pointing is currently empty
	private int capacity = 0;
	
	@SuppressWarnings("unchecked")
	public ArrayStack(Class<T> clazz, int capacity) {
		array = (T[]) Array.newInstance(clazz, capacity);
		this.capacity = capacity; 
	}

	@Override
	public synchronized boolean isEmpty() {
		return index == 0 ? true : false;
	}

	@Override
	public synchronized void push(T value) throws Exception {
		if (index >= capacity) { // index goes from 0 to N-1, if index becomes equal to N (i.e capacity) then the stack is full
			throw new Exception("Stack full.");
		}
		array[index] = value; 
		index++;
		System.out.println("Pushed values " + value);
	}

	@Override
	public synchronized T pop() throws Exception {
		if (index == 0) {
			throw new Exception(" Stack Enpty.");
		}
		index--;
		T value  = array[index];
		System.out.println("Popped value " + value);
		return value;
	}
}
