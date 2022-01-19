package com.threads;

import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class TimerMemorySamples {

	private static Map<Integer, Timer> timersByMeIdAndCarrierId = new ConcurrentHashMap<>();
	private static final long LOAD_TENDER_UPDATE_DELAY_TIME = 60 * 3000l;

	public static void main(String args[]) {
		TimerMemorySamples obj = new TimerMemorySamples();

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

		System.out.println(" startMemory = " + startMemory + " currentMemory = " + currentMemory + " finalMemory = "
				+ finalMemory);

	}

	private long getFreeMemory() {
		return (Runtime.getRuntime().freeMemory()) / (1024 * 1024);
	}

	private void scheduleTimers() {
		for (int i = 0; i < 5000; i++) {

			Timer timer = timersByMeIdAndCarrierId.get(i);
			if (timer != null) {
				timer.cancel();
			}
			timer = new Timer();
			timersByMeIdAndCarrierId.put(i, timer);
			timer.schedule(new DummyTask(i), LOAD_TENDER_UPDATE_DELAY_TIME);
		}

	}

	class DummyTask extends TimerTask {

		int count = 0;

		public DummyTask(int count) {
			this.count = count;
		}

		@Override
		public void run() {
			System.out.println("Tast Executed: #" + count);

		}

	}

	static class CancelAllTimersTask extends TimerTask {

		@Override
		public void run() {
			int i = 0;
			for (Timer timer : timersByMeIdAndCarrierId.values()) {
				if (timer != null) {
					timer.cancel();
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
