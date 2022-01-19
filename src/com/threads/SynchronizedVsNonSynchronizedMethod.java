package com.threads;

public class SynchronizedVsNonSynchronizedMethod {

	int number = 1;

	public synchronized void test() {
		for (int i = 0; i < 5; i++) {
			try {
				Thread.sleep(400);
				number++;
				System.out.println("test = " + number);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public void test1() {
		for (int i = 0; i < 5; i++) {
			try {
				Thread.sleep(400);
				number++;
				System.out.println("test1 = " + number);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public static void main(String args[]) {
		SynchronizedVsNonSynchronizedMethod obj = new SynchronizedVsNonSynchronizedMethod();
		new Thread(new Runnable() {

			@Override
			public void run() {
				obj.test();
			}
		}).start();
		obj.test1();
	}
}
