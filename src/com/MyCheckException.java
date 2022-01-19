package com;

public class MyCheckException extends Exception {

	public static void main(String args[]) {

		try {
			throw new Exception("try");
		} catch (Exception e) {
			throw new Exception("catch");
		} finally {
			throw new RuntimeException("finally");
		}
	}

	private static void badMethod() {
		//throw new Error();
	}
}
