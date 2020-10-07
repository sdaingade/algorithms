package javads;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueEg {

	private static int QUEUE_SIZE = 10;

	private static class Producer implements Runnable {
		private BlockingQueue<Integer> blockingQueue;

		public Producer(BlockingQueue<Integer> blockingQueue) {
			this.blockingQueue = blockingQueue;
		}

		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				try {
					blockingQueue.put(i);
					System.out.println("Put in queue " + i);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

	private static class Consumer implements Runnable {
		private BlockingQueue<Integer> blockingQueue;

		public Consumer(BlockingQueue<Integer> blockingQueue) {
			this.blockingQueue = blockingQueue;
		}

		@Override
		public void run() {
			while(true) {
				try {
					Integer i = blockingQueue.take();
					System.out.println("Taken from queue " + i);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

	
	public static void main(String[] args) {
		BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<Integer>(QUEUE_SIZE);
		Thread t1 = new Thread(new Producer(blockingQueue));
		Thread t2 = new Thread(new Consumer(blockingQueue));

		t1.start();
		t2.start();
	}
}
