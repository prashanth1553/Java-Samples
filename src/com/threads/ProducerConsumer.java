package com.threads;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ProducerConsumer {

	private List<Integer> list = new ArrayList<>();

	static class Producer implements Runnable {

		List<Integer> list;

		public Producer(List<Integer> list) {
			this.list = list;
		}

		@Override
		public void run() {
			for (int i = 0; i < 5; i++) {
				synchronized (list) {
					if (!list.isEmpty()) {
						try {
							list.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					for (int j = 0; j < 5; j++) {
						System.out.println("Adding === " + j);
						list.add(new Integer(j));
					}
					list.notifyAll();
				}

			}
		}
	}

	static class Consumer implements Runnable {

		List<Integer> list;

		public Consumer(List<Integer> list) {
			this.list = list;
		}

		@Override
		public void run() {
			for (int i = 0; i < 5; i++) {
				synchronized (list) {
					if (list.isEmpty()) {
						try {
							list.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					Iterator<Integer> itr = list.iterator();
					while (itr.hasNext()) {
						Integer next = itr.next();
						System.out.println("Consuming == " + next);
						itr.remove();
					}
					list.notifyAll();
				}
			}
		}
	}

	public static void Mymain(String args[]) {
		ProducerConsumer pc = new ProducerConsumer();
		Producer p = new Producer(pc.list);
		Consumer c = new Consumer(pc.list);
		new Thread(c).start();
		new Thread(p).start();
	}

	public static class PC {

		// Create a list shared by producer and consumer
		// Size of list is 2.
		LinkedList<Integer> list = new LinkedList<>();
		int capacity = 2;

		// Function called by producer thread
		public void produce() throws InterruptedException {
			int value = 0;
			while (true) {
				synchronized (this) {
					// producer thread waits while list
					// is full
					while (list.size() == capacity)
						wait();

					System.out.println("Producer produced-" + value);

					// to insert the jobs in the list
					list.add(value++);

					// notifies the consumer thread that
					// now it can start consuming
					notify();

					// makes the working of program easier
					// to understand
					//Thread.sleep(1000);
				}

			}
		}

		// Function called by consumer thread
		public void consume() throws InterruptedException {
			while (true) {
				synchronized (this) {
					// consumer thread waits while list
					// is empty
					while (list.size() == 0)
						wait();

					// to retrive the ifrst job in the list
					int val = list.removeFirst();

					System.out.println("Consumer consumed-" + val);

					// Wake up producer thread
					notify();

					// and sleep
					//Thread.sleep(500);
				}
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		// Object of a class that has both produce()
		// and consume() methods
		final PC pc = new PC();

		// Create producer thread
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					pc.produce();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		// Create consumer thread
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					pc.consume();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		// Start both threads
		t1.start();
		t2.start();

		// t1 finishes before t2
		t1.join();
		t2.join();
	}
}
