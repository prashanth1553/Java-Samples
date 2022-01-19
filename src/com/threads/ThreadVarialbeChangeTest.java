package com.threads;

public class ThreadVarialbeChangeTest implements Runnable {

	private Object obj = new Object();

	public static void main(String[] args) {

		ThreadVarialbeChangeTest test = new ThreadVarialbeChangeTest();
		Thread t1 = new Thread(test);
		t1.setName("T1");
		Thread t2 = new Thread(test);
		t2.setName("T2");
		Thread t3 = new Thread(test);
		t3.setName("T3");
		
		t1.start();
		t2.start();
		t3.start();

	}

	@Override
	public void run() {
		synchronized (obj) {
			System.out.println("1 " + Thread.currentThread().getName());
			obj = new Object();
			try {
				Thread.currentThread().sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("2 " + Thread.currentThread().getName());
		}

	}
}
