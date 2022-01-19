package com.venkatesh;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Venky1 {

	public int add(short i, int j) {
		return i + j;
	}

	public static void main(String args[]) {
		Short s = 9;
		Venky1 obj = new Venky1();
		System.out.println(obj.add(s, 6));
	}

	public static int degreeOfArray(List<Integer> arr) {
		// Write your code here

		if (arr != null && arr.size() > 0) {

			Map<Integer, Integer> count = new HashMap<>();
			Map<Integer, Integer> left = new HashMap<>();
			Map<Integer, Integer> right = new HashMap<>();
			int degree = 0;
			for (int i = 0; i < arr.size(); i++) {
				int num = arr.get(i);
				if (!left.containsKey(num)) {
					left.put(num, i);
				}
				right.put(num, i);
				count.put(num, count.getOrDefault(num, 0) + 1);
				degree = Math.max(degree, count.get(num));
			}
			int ans = arr.size();
			for (int key : count.keySet()) {
				if (count.get(key) == degree) {
					ans = Math.min(ans, right.get(key) - left.get(key) + 1);
				}
			}
			return ans;
		} else {
			return 0;
		}
	}

}
