package javads;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * PriorityQueue is an unbounded Queue implementation in Java, which is based on priority heap.
 * PriorityQueue allows you to keep elements in a particular order, according to there natural order
 * or custom order defined by Comparator interface in Java. Head of priority queue data structure will
 * always contain least element with respect to specified ordering. For example, in this post, we will
 * create a PriorityQueue of Items, which are ordered based upon there price, this will allow us to process Items,
 * starting from lowest price. Priority queue is also very useful in implementing Dijkstra algorithm in Java.
 * You can use to PriorityQueue to keep unsettled nodes for processing. One of the key thing to remember about
 * PriorityQueue in Java is that it's Iterator doesn't guarantee any order, if you want to traverse in ordered fashion,
 * better use Arrays.sort(pq.toArray()) method.
 * 
 * PriorityQueue is also not synchronized, which means can not be shared safely between multiple threads,
 * instead it's concurrent counterpart PriorityBlockingQueue is thread-safe and should be used in multithreaded environment.
 * 
 * Priority queue provides O(log(n)) time performance for common enqueing and dequeing methods
 * e.g. offer(), poll() and add(), but constant time for retrieval methods e.g. peek() and element().
 *
 */

public class PriorityQueueEg {
	
	public static class Item implements Comparable<Item> {
		private String name;
		private int price;
		
		public Item(String name, int price) {
			this.name = name;
			this.price = price;
		}

		@Override
		public int compareTo(Item o) {
			return this.price - o.price;
		}
		
		@Override
		public boolean equals(Object o) {
			if(o == null || this.getClass() != o.getClass() ||
			   this.price != ((Item)o).price || !this.name.equals(((Item) o).name)) {
				return false;
			}
			return true;
		}
		
		@Override
		public String toString() {
			return String.format(" %s : %d", this.name, this.price);
		}
		
	}

	public static void main(String[] args) {
		Queue<Item> queue = new PriorityQueue<Item>();
		queue.add(new Item("iphone", 900));
		queue.add(new Item("ipad", 1200));
		queue.add(new Item("xbox", 300));
		queue.add(new Item("iwatch", 200));
		
		System.out.println("Order of items in PriorityQueue");
        System.out.println(queue);
        
        System.out.println("Element consumed from head of the PriorityQueue : " + queue.poll());
        System.out.println(queue);
        
        System.out.println("Element consumed from head of the PriorityQueue : " + queue.poll());
        System.out.println(queue);
        
        System.out.println("Element consumed from head of the PriorityQueue : " + queue.poll());
        System.out.println(queue);

	}

}
