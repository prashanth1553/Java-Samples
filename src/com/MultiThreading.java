package com;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;

public class MultiThreading {

	public static Map<String, Integer> counter = new TreeMap<>();
	public static Queue<String> items = new LinkedList<>();
	public static volatile boolean stop = false;

	public static void main(String args[]) throws Exception {

		Scanner s = new Scanner(System.in);
		new Thread(processor).start();
		while (s.hasNextLine()) {
			String line = s.nextLine().trim();
			items.add(line);
		}
		while (items.isEmpty()) {
			// try{
			// Thread.sleep(100);
			// }catch(Exception e){

			// }
		}
		stop = true;

		System.out.println(counter);
	}

	static Runnable processor = () -> {

		while (true) {
			if (!items.isEmpty()) {
				String line = items.poll();
				String words[] = line.split(" ");
				for (String w : words) {
					w = w.replace(".", "");
					w = w.replace(",", "");
					w = w.toLowerCase();
					counter.compute(w, (k, v) -> v == null ? 1 : v + 1);
				}
			}
			if (stop) {
				break;
			}

		}
	};
}
