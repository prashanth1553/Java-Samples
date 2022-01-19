package com;

public class MyThread {

	final String resource1 = "111111";
	final String resource2 = "222222";

	private void method1() {

		synchronized (resource1) {
			System.out.println("Thread 1: locked resource 1");

			try {
				Thread.sleep(10000);
			} catch (Exception e) {
			}

			System.out.println("Thread 1: locked resource 2" + resource2);

		}
	}

	private void method2() {

		synchronized (resource2) {
			System.out.println("Thread 2: locked resource 2");
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
			}

			synchronized (resource1) {
				System.out.println("Thread 2: locked resource 1 " + resource1);
			}

		}
	}

	public static void main(String args[]) {

		MyThread obj = new MyThread();
		Thread t1 = new Thread() {
			@Override
			public void run() {
				obj.method1();
			}
		};
		Thread t2 = new Thread() {
			@Override
			public void run() {
				obj.method2();
			}
		};

		t1.start();
		t2.start();

		try {
			Thread.sleep(100);
		} catch (Exception e) {
		}
		System.out.println("t1 " + t1.getState().name());
		System.out.println("t2" + t2.getState().name());

	}

}
