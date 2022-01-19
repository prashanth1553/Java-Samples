package com;

import java.util.Stack;

public class AreaUnderHistogram {

	public static long maxAreaUnderHistogram(int array[]) {
		long area = 0;

		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < array.length; i++) {
			if (!stack.isEmpty()) {
				while (!stack.isEmpty() && array[stack.peek()] > array[i]) {
					int currentIndex = stack.pop();
					int leftI = stack.isEmpty() ? -1 : stack.peek();
					area = Math.max(area, array[currentIndex] * (i - leftI - 1));
				}
			}
			stack.add(i);
		}

		while (!stack.isEmpty()) {
			int currentIndex = stack.pop();
			area = Math.max(area, (array[currentIndex] * (array.length - currentIndex)));
		}

		return area;

	}

	public static void main(String args[]) {
		int array[] = { 18, 2, 5, 4, 5, 1, 18 };
		System.out.println(maxAreaUnderHistogram(array));
	}
}
