package com.threads;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableTest implements Callable<String> {

	@Override
	public String call() throws Exception {
		Thread.sleep(1000);
		// return the thread name executing this callable task
		throw new CustomExp();
//		return Thread.currentThread().getName();
	}

	public static void main(String args[]) throws InterruptedException {

		ExecutorService executorService = Executors.newFixedThreadPool(10);

		List<Future<String>> list = new ArrayList<Future<String>>();

		CallableTest callObj = new CallableTest();
		
		for (int i = 0; i < 1; i++) {
			Future<String> f = executorService.submit(callObj);
			list.add(f);
		}

		for (int i = 0; i < 1; i++) {
			try {
			System.out.println(list.get(i).get());
			}catch(ExecutionException e) {
				System.out.println(e.getCause().getMessage());
			}
		}

		executorService.shutdown();
		
	}

	public void foreachMethod() {

		Map<Integer, Integer> map = new HashMap<>();
		map.forEach((key, v) -> {
			System.out.println("");
		});

		map.forEach((key, value) -> System.out.printf("key: %s; value: %s; thread: %s\n", key, value,
				Thread.currentThread().getName()));

	}

	static class CustomExp extends Exception {

	}
}
