package com.threads;

public class ThreadException implements Runnable {

	@Override
	public void run() {
		System.out.println("run ");
		throw new RuntimeException("exception");
	}

	public static void main(String args[]) {

		Thread t = new Thread(new ThreadException());
		t.start();
		System.out.println("end");

	}

}
