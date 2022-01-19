package com.threads;

public class AvailableMemory {

	public static void main(String args[]) {
		System.out.println(getFreeMemory());
	}
	
	
	private static long getFreeMemory() {
		return (Runtime.getRuntime().freeMemory()) / (1024 * 1024);
	}
}
