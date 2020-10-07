package algorithms;

public interface Stack<T> {

	public boolean isEmpty();

	public void push(T value) throws Exception;
	
	public T pop() throws Exception;
}
