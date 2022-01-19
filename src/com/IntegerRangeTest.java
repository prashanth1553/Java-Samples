package com;

import java.util.Arrays;

public class IntegerRangeTest {

	public static void main(String args[]) {

		int i = -2147483641;
		System.out.println(Math.abs(i));
		long l =  25 * 60 * 1000;
		System.out.println(l);
		
		Integer j = Integer.MAX_VALUE+1;
		System.out.println(j+10);
	}

	public static void main1(String[] args) {
		int[] array = { 4, 4, 4, 3, 7, 8, 5, 5, 9, 9, 10 };
		Arrays.sort(array);
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] == array[i + 1]) {
				continue;
			} else {
				System.out.print(array[i]);
			}
		}
	}
}