package com;

import java.io.IOException;

public class FinallyTest {

	public static void main1(String args[]) {

		try {
			String s = null;
			s.length();
		} catch (Exception e) {
			System.out.println("1");
			System.out.println("2");
		} finally {
			System.out.println("finally");
		}
	}

	int m() throws Exception {
		try {
			throw new Exception("");
		} catch (Exception e) {
			throw new Exception("catch");
		}finally {
			throw new Exception("finally");
		}
	}

	void n() {
		//System.out.println(m());
		throw new IllegalArgumentException();
	}

	void p() {
		n();
	}

	public static void main(String args[]) throws Exception {
		FinallyTest obj = new FinallyTest();
		obj.m();
		System.out.println("normal flow...");
	}
	
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
	}
}
