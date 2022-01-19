package com.inheritance;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {

	public static void main(String args[]) {

		// sleepstream sleep stream
//		Integer a = Stream.of(100000, 200000, 500000, 400000, 500000).filter(e -> e > 300)
//				.peek(e -> System.out.println("Filtered value: " + e)).findFirst().orElse(-1);
//		System.out.println(a);

		Stream.of("one", "two", "three", "four").filter(e -> e.length() > 3)
				.peek(e -> System.out.println("Filtered value: " + e)).map(String::toUpperCase)
				.peek(e -> System.out.println("Mapped value: " + e)).findFirst().orElse("nothing");

//		long count = Stream.of("one", "two", "three", "four").filter(e -> e.length() > 3)
//				.peek(e -> System.out.println("Filtered value: " + e)).map(String::toUpperCase)
//				.peek(e -> System.out.println("Mapped value: " + e)).count();
//		System.out.println(" count == " + count);

//		Test obj = new Test();
//		obj.test(null);
//
//		obj.sum(1, 2l);
//
//		Parent parent = new Parent();
//		parent.inheritanceTest = "";
//		Child ch = new Child();
//		parent = ch;
//		parent.inheritanceTest = "Modified";
//		ch = (Child) parent;
//		System.out.println(ch.inheritanceTest());
//
//		obj.stringTest();
//		
//		System.out.println(Integer.MAX_VALUE == 0X7fffffff);
	}

	private void test(String a) {
		System.out.println("String");
	}

	private void test(Object a) {
		System.out.println("Object");

	}

	void sum(int a, long b) {
		System.out.println("int arg method invoked");
	}

	void sum(long a, int b) {
		System.out.println("long arg method invoked");
	}

	private void stringTest() {
		String s1 = "Sachin";
		String s2 = "Sachin";
		String s3 = new String("Sachin");
		System.out.println(s1 == s2);// true
		System.out.println(s2 == s3);// false
		s3 = s3.intern();
		System.out.println(s2 == s3);// true

	}
}
