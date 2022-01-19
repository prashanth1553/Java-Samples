package com;

public class ReturnTest {

	public static void method1() {
		method2();
		System.out.println("Method 1");
	}

	public static void method2() {
		return;
	}
	
	public static void main(String args[]) {
		method1();
	}
}
