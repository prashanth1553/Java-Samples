package com.threads;

import java.util.concurrent.atomic.AtomicInteger;

public class EvenOddThreads {

//	public static boolean isEven;

	public static void main(String args[]) {
		int max = 20;
		AtomicInteger current = new AtomicInteger(1);
		new Thread(new Job(current, false, max), "Odd").start();
		new Thread(new Job(current, true, max), "Even").start();

	}

	static class Job implements Runnable {

		private AtomicInteger current;
		private boolean isEven;
		private int max;

		public Job(AtomicInteger current, boolean isEven, int max) {
			super();
			this.current = current;
			this.isEven = isEven;
			this.max = max;
		}

		@Override
		public void run() {
			while (true) {
				synchronized (current) {
					if ((this.isEven && current.get() % 2 == 0) || (!this.isEven && current.get() % 2 == 1)) {
						if (max >= (current.get())) {
							System.out
									.println(" Thread name: " + Thread.currentThread().getName() + " " + current.get());
							current.addAndGet(1);
							current.notifyAll();
						} else {
							current.notifyAll();
							break;
						}
					} else {
						try {
							current.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}

			}

		}

	}
}
