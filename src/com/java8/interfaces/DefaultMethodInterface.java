package com.java8.interfaces;

import java.util.Arrays;
import java.util.List;

public interface DefaultMethodInterface {

	public default void defaultMethod() {
		System.out.println("DefaultMethod interface");

		int sum = Arrays.stream(new String[] { "1", "2", "3" }).filter(i -> i.equals("2"))
				.mapToInt(i -> Integer.parseInt(i)).sum();

		List<String> vechicles = Arrays.asList("bus", "car", "bicycle", "flight", "train");
		vechicles.stream().filter(str -> str.length() > 3).map(String::toUpperCase).sorted()
				.forEach(System.out::println);
		
		Arrays.asList("bus", "car", "bicycle", "flight", "train");
		vechicles.stream().filter(str -> str.length() > 3).map(i -> i.toUpperCase()).sorted()
				.forEach(System.out::println);
	}

	public static void main(String agrs[]) {
	}
}
