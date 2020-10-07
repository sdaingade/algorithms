package javads;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier is a natural requirement for concurrent program because it can be used to perform final part
 * of task once individual tasks  are completed. All threads which wait for each other to reach barrier are called parties,
 * CyclicBarrier is initialized with number of parties to be wait and threads wait for each other by calling CyclicBarrier.await()
 * method which is a blocking method in Java and blocks until all Thread or parties call await().
 * In general calling await() is shout out that Thread is waiting on barrier.
 * await() is a blocking call but can be timed out or Interrupted by other thread.
 * 
 *  If you look at CyclicBarrier it also the does the same thing as CountDownLatch but there is a difference.
 *  You cannot reuse CountDownLatch once count reaches zero while you can reuse CyclicBarrier by calling reset() method
 *  which resets Barrier to its initial State. What it implies that CountDownLatch is good for one time event like application
 *  start-up time and CyclicBarrier can be used to in case of recurrent event e.g. concurrently calculating solution of big problem etc
 * 
 * @author home
 *
 */

public class CyclicBarrierEg {

	private static class Task implements Runnable {
		private CyclicBarrier cyclicBarrier;

		public Task(CyclicBarrier cb) {
			this.cyclicBarrier = cb;
		}

		@Override
		public void run() {
			System.out.println("Thread " + Thread.currentThread().getId()  +
					" is waiting for other threads to reach barrier...");
			try {
				cyclicBarrier.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
				return;
			} catch (BrokenBarrierException e) {
				e.printStackTrace();
				return;
			}
			System.out.println("Thread " + Thread.currentThread().getId()  +
					" is now past the barrier...");
		}
		
	}
	
	public static void main(String[] args) {

		final CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new Runnable() {

			@Override
			public void run() {
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("All threads arrived at barrier...");

			}
		});
		
		Thread t1 = new Thread(new Task(cyclicBarrier));
		Thread t2 = new Thread(new Task(cyclicBarrier));
		Thread t3 = new Thread(new Task(cyclicBarrier));
		
		t1.start();
		t2.start();
		t3.start();

	}

}
