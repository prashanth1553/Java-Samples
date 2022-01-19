package com.threads;

import java.util.ArrayList;

public class ThreadSync {

	public Integer myIncrementor = 1;

	void printTable(Integer n) {// synchronized method

		for (int i = 1; i <= 5; i++) {
			System.out.println(n * i);
			try {
				int a=0;
				Thread.sleep(400);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		synchronized (myIncrementor) {
			myIncrementor++;
			// myIncrementor = myIncrementor + 1;
			int a = myIncrementor;
			System.out.println("myIncrementor " + a);

		}

	}

	public static class MyThread1 extends Thread {
		ThreadSync t;

		MyThread1(ThreadSync t) {
			this.t = t;
		}

		public void run() {
			t.printTable(5);
		}

	}

	public static class MyThread2 extends Thread {
		ThreadSync t;

		MyThread2(ThreadSync t) {
			this.t = t;
		}

		public void run() {
			t.printTable(100);
		}

	}

	public static void main(String args[]) {
		ThreadSync obj = new ThreadSync();// only one object
//		MyThread1 t1 = new MyThread1(obj);
//		MyThread2 t2 = new MyThread2(obj);
//		t1.start();
//		t2.start();
//
//		try {
//			t1.join();
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//
//		try {
//			t2.join();
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//		System.out.println("myIncrementor " + obj.myIncrementor);

		ArrayList<Integer> A = new ArrayList<Integer>();
		A.add(117);
		A.add(84);
		A.add(50);
		A.add(119);
		A.add(74);
		A.add(128);
		System.out.println(obj.solve(A, 58));
		
		try {
			System.out.println("sonar test");
		}catch(RuntimeException e) {
			
		}
	}

	public int solve(ArrayList<Integer> A, int B) {
		int lo = B, hi = A.stream().mapToInt(Integer::intValue).max().getAsInt();
		int ans = -1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			long posible = sum(A, mid);
			if (posible == B) {
				return mid;
			} else if (posible > B) {
				ans = mid;
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}
		}
		return ans;

	}

	private long sum(ArrayList<Integer> A, int ans) {
		long sum = 0;
		for (int e : A) {
			long r = e - ans;
			if (r > 0) {
				sum += r;
			}
		}
		return sum;
	}
}