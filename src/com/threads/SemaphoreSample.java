package com.threads;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.Semaphore;
import java.util.stream.Stream;

public class SemaphoreSample {

	private Semaphore counter;

	public SemaphoreSample(int count) {
		counter = new Semaphore(count);
	}

	public boolean testSemaphore() {
		if (!counter.tryAcquire()) {
			return false;
		}
		try {
			Thread.sleep(2000l);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		counter.release();
		return true;
	}

	public static void main(String args[]) {
		final SemaphoreSample obj = new SemaphoreSample(5);
		Stream<Thread> threads = Stream.generate(() -> new Thread() {
			public void run() {
				System.out.println(obj.testSemaphore());
			};
		});
		threads.limit(8).forEach(i -> i.start());

		Stack<Integer> stack = new Stack<>();

		// test semaphore initilized with zero;
		final Semaphore zeroSemaphore = new Semaphore(0);
		Runnable shop = () -> {
			System.out.println("Wait for customer");
			try {
				System.out.println("availablePermits for shop " + zeroSemaphore.availablePermits());
				zeroSemaphore.acquire();
				System.out.println("Serverd the customer ");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};

		Runnable customer = () -> {
			System.out.println("availablePermits for customer " + zeroSemaphore.availablePermits());
			zeroSemaphore.release();
			System.out.println("availablePermits for customer " + zeroSemaphore.availablePermits());
		};
		new Thread(shop).start();
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Thread(customer).start();

	}

}
