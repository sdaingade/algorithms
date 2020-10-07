package tests;

import java.util.Random;

public class ProducerConsumer {
  private static final int N = 10;
  private static Object lock = new Object();
  private static int[] buffer = new int[N];
  private static int read = 0;
  private static int write = 0;
  private static int count = 0;

  private static class Producer implements Runnable {
	private Random random  = new Random(100);

	@Override
	public void run() {
	  while(true) {	
		synchronized(lock) {
			while (count >= N) {
				try {
					System.out.println(String.format("Thread %s : Waiting...", Thread.currentThread().getId()));
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			buffer[write] = random.nextInt();
			System.out.println(String.format("Thread %s : Produced %n", Thread.currentThread().getId(), buffer[write]));
			write = (write +1) % N;
			count++;
			lock.notifyAll();
		}

		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	  }
	}

  }
  

  private static class Consumer implements Runnable {

	@Override
	public void run() {
		while(true) {
			synchronized(lock) {
				while(count <= 0) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(String.format("Thread %s : Consumed %n", Thread.currentThread().getId(), buffer[read]));
				read = (read +1) % N;
				count--;
				lock.notifyAll();
			}

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	  
  }

  public static void main(String[] args) {
	  new Thread(new Producer()).start();
	  new Thread(new Consumer()).start();
  }
  
}
