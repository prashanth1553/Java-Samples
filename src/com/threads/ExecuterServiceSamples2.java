package com.threads;

import java.util.Map;
import java.util.TimerTask;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecuterServiceSamples2 {

	private static Map<Integer, ScheduledFuture> timersByMeIdAndCarrierId = new ConcurrentHashMap<>();
	private static final long LOAD_TENDER_UPDATE_DELAY_TIME = 60 * 3000l;
	private static final ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1);

	public static void main(String args[]) {
		executor.setRemoveOnCancelPolicy(true);

		ExecuterServiceSamples2 obj = new ExecuterServiceSamples2();

		long startMemory = obj.getFreeMemory();

		obj.scheduleTimers();

		long currentMemory = obj.getFreeMemory();

		try {
			Thread.sleep(60 * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(" startMemory = " + startMemory + " currentMemory = " + currentMemory);

		new CancelAllTimersTask().run();

		long finalMemory = obj.getFreeMemory();

		try {
			executor.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		executor.shutdown();

		System.out.println(" startMemory = " + startMemory + " currentMemory = " + currentMemory + " finalMemory = "
				+ finalMemory);

	}

	private long getFreeMemory() {
		return (Runtime.getRuntime().freeMemory()) / (1024 * 1024);
	}

	private void scheduleTimers() {
		for (int i = 0; i < 10000; i++) {

			ScheduledFuture<Integer> scheduledFuture = executor.schedule(new DummyTask(i),
					LOAD_TENDER_UPDATE_DELAY_TIME, TimeUnit.MILLISECONDS);

			timersByMeIdAndCarrierId.put(i, scheduledFuture);
		}

	}

	class DummyTask implements Callable<Integer> {

		int count = 0;

		public DummyTask(int count) {
			this.count = count;
		}

		@Override
		public Integer call() throws Exception {
			System.out.println("Tast Executed: #" + count);
			return 1;
		}

	}

	static class CancelAllTimersTask extends TimerTask {

		@Override
		public void run() {
			int i = 0;
			for (ScheduledFuture scheduledFuture : timersByMeIdAndCarrierId.values()) {
				if (scheduledFuture != null) {
					scheduledFuture.cancel(false);
					i++;
				}
			}
			timersByMeIdAndCarrierId.clear();
			System.out.println("Cancalled tasks " + i);
		}

	}

	public void testScheduledExecutorService() {

		ScheduledThreadPoolExecutor scheduler = new ScheduledThreadPoolExecutor(1);

	}
}
