package com.java8.interfaces;

import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class DefaultMethodClass {

	private String name;

	public DefaultMethodClass(String name) {
		this.name = name;
	}

	public DefaultMethodClass() {
	}

	/*
	 * public void defaultMethod1() {
	 * System.out.println("DefaultMethod DefaultMethodClass"); }
	 */

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static void main(String args[]) {
		DefaultMethodClass obj1 = new DefaultMethodClass();
		DefaultMethodClass obj2 = new DefaultMethodClass("naem");

	}

	private static boolean isPrime(int number) {
		IntPredicate isDivisible = index -> number % index == 0;

		return number > 1 && IntStream.range(2, number).noneMatch(isDivisible);
	}

}
