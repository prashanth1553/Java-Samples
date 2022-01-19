package com.threads;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountDownLatchTest {

	public static void main(String args[]) {

		CountDownLatch latch = new CountDownLatch(5);
		List<Thread> threads = Stream.generate(() -> new Thread(new Worker(latch))).limit(5)
				.collect(Collectors.toList());
		threads.forEach(t -> t.start());

		try {
			latch.wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static class Worker implements Runnable {

		CountDownLatch latch;

		public Worker(CountDownLatch latch) {
			this.latch = latch;
		}

		@Override
		public void run() {
			// do some work
			latch.countDown();

		}

	}
}
