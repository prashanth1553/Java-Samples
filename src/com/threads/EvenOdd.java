package com.threads;

public class EvenOdd {

	Integer incrementer = 0;

	public void incrementEven() {
		while (true) {
			synchronized (this) {
				if (incrementer >= 10) {
					notifyAll();
					break;
				}
				if (incrementer % 2 == 0) {
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println((Thread.currentThread().getName() + " ") + (++incrementer));
				notifyAll();
			}

		}
	}

	public void incrementOdd() {
		while (true) {
			synchronized (this) {
				if (incrementer % 2 != 0) {
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if (incrementer >= 10) {
					notifyAll();
					break;
				}
				System.out.println((Thread.currentThread().getName() + " ") + (++incrementer));
				notifyAll();
			}

		}
	}

	public static void main(String args[]) {
		EvenOdd obj = new EvenOdd();
		Runnable even = () -> obj.incrementEven();
		Runnable odd = () -> obj.incrementOdd();
		new Thread(even, "EVEN").start();
		new Thread(odd, "ODD").start();

	}

}
