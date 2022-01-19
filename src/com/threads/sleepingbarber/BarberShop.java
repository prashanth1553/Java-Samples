package com.threads.sleepingbarber;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/*
 * https://turkogluc.com/java-concurrency-sleeping-barber/
 * 
 * Our solution contains 2 Rendezvouses synchronisation pattern first one with customerReady and barberReady, 
 * second one with customerDone and barberDone semaphores. We could alternatively use a barrier here to justify 
 * that barber will not start to work on another customer before the current one will leave. So we try to make these 2 threads 
 * to finish at the same time.
 */
public class BarberShop {

	// this lock is handled for the critical section of allowed number of customers
	private final ReentrantLock mutex;

	private final Semaphore customerReady;
	private final Semaphore barberReady;

	private final Semaphore customerDone;
	private final Semaphore barberDone;

	private final int limit;

	private final Barber barber;

	private int customers;

	public BarberShop(int limit) {
		this.limit = limit;
		mutex = new ReentrantLock();

		customerReady = new Semaphore(0);
		barberReady = new Semaphore(0);

		customerDone = new Semaphore(0);
		barberDone = new Semaphore(0);

		barber = new Barber();

	}

	public void startService() {

		// wait for a customer to arrive
		try {
			customerReady.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// signal that barber is ready
		barberReady.release();

		// give a haircut
		barber.cutHair();

		// wait for a customer to approve done
		try {
			customerDone.acquire();
		} catch (InterruptedException e) {
			System.out.println("Barber wait task is interrupted: " + e.getMessage());
		}

		// signal the customer that barber is done
		barberDone.release();
		System.out.println("Haircut is done");

	}

	public void receiveNewCustomer(Customer customer) {

		customer.enter();
		mutex.lock();
		if (limit == customers) {
			mutex.unlock();
			customer.leave();
			return;
		}
		customers++;
		mutex.unlock();

		customerReady.release();

		// wait for the barber to be available
		try {
			barberReady.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// get the haircut
		customer.getHairCut();

		customerDone.release();

		try {
			barberDone.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		mutex.lock();
		customers -= 1;
		mutex.unlock();
	}

	public static void main(String args[]) {
		final int NUM_ITERATION = 8;
		ExecutorService executor = Executors.newWorkStealingPool();
		BarberShop barbershop = new BarberShop(4);

		Runnable barbershopTask = barbershop::startService;

		AtomicInteger customerName = new AtomicInteger();

		Runnable customerTask = () -> {
			barbershop.receiveNewCustomer(new Customer(String.valueOf(customerName.getAndIncrement())));
		};

		for (int i = 0; i < NUM_ITERATION; i++) {
			executor.submit(barbershopTask);
			executor.execute(customerTask);
		}

		executor.shutdown();
		try {
			executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
		} catch (InterruptedException e) {
		}

	}

}
