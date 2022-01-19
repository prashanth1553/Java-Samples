package com.venkatesh;

public class SriramSubArray {

	public static void main(String args[]) {

		int K = 4;
		int[] A = {4, 5, 7, 1, 2, 9, 8, 4, 3, 1};
		int N = A.length;

		int ans = 0;
		int i = 0;
		while (i < N) {
			int currentCount = 0;
			boolean isKFound = false;
			while (i < N && A[i] <= K) {
				currentCount++;
				if (A[i] == K) {
					isKFound = true;
				}
				i++;
			}
			if (isKFound) {
				ans += currentCount;
			}
			while (i < N && A[i] > K) {
				i++;
			}

		}
		System.out.println("ans == " + ans);

	}

}
