package javads;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/*
 * CountDownLatch in Java is a kind of synchronizer which allows one Thread
 * to wait for one or more Threads before starts processing.
 *
 * CountDownLatch works in latch principle,  main thread will wait until Gate is open.
 * One thread waits for n number of threads specified while creating CountDownLatch in Java.
 * Any thread, usually main thread of application,  which calls CountDownLatch.await()
 * will wait until count reaches zero or its interrupted by another Thread.
 * All other thread are required to do count down by calling CountDownLatch.countDown()
 * once they are completed or ready to the job. as soon as count reaches zero, Thread awaiting starts running.
 * One of the disadvantage of CountDownLatch is that its not reusable once count reaches
 * to zero you can not use CountDownLatch any more, but don't worry Java concurrency API
 * has another concurrent utility called CyclicBarrier for such requirements.
 */

public class CountDownLatchEg {
	
	private static class Service implements Runnable {
		private String serviceName;
		private int timeout;
		private CountDownLatch latch;
		
		public Service (String serviceName, int timeout, CountDownLatch latch) {
			this.serviceName = serviceName;
			this.timeout = timeout;
			this.latch = latch;
		}

		@Override
		public void run() {
			System.out.println("Starting service " + serviceName + "...");
			try {
				Thread.sleep(timeout);
			} catch (InterruptedException e) {
				e.printStackTrace();
				return;
			}

			latch.countDown();
			System.out.println("Service " + serviceName + " started successfully.");
		}
	}

	public static void main(String[] args) {
		final CountDownLatch countDownLatch = new CountDownLatch(3);

		Thread cacheService = new Thread(new Service("CacheService", 1000, countDownLatch));
		Thread alertService = new Thread(new Service("AlertService", 1000, countDownLatch));
		Thread validationService = new Thread(new Service("ValidationService", 1000, countDownLatch));
		
		cacheService.start();
		alertService.start();
		validationService.start();

		try {
			countDownLatch.await(10000, TimeUnit.MILLISECONDS);
		} catch (InterruptedException ie) {
			System.out.println("Failed to start important services. Terminating...");
			ie.printStackTrace();
			return;
		}
		System.out.println("All services are up and running.");
	}
}
