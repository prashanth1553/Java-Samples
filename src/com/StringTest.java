package com;

public class StringTest {

	public static void main(String args[]) {

		String a = "abc";
		String b = "abc";
		System.out.println(a == b);

		// intern test
		String intern = new String("abc");
		System.out.println("before inter = " + (a == intern));

		intern = intern.intern();
		System.out.println("after inter = " + (a == intern));

		String bb = "abc";
		System.out.println("after inter = " + (bb == intern));

		//
		String value = String.valueOf("abc");
		System.out.println("after inter = " + (intern == value));
		
		

	}
}
