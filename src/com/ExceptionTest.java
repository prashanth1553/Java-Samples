package com;

public class ExceptionTest {

	public static void main(String args[]) {

		try {
			throw new RuntimeException();
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("after exception");
		}
		System.out.println((int) 'a');
		System.out.println((int) 'A');

	}
}
