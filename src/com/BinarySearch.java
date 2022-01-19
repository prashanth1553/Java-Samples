package com;

public class BinarySearch {

	private void search(int array[], int k) {
		int l = 0, h = array.length - 1;
		while (l <= h) {

			int m = l + (h - l) / 2;
			int e = array[m];
			if (e > k) {
				h = m - 1;
			} else if (e < k) {
				l = m + 1;
			} else {

				System.out.println("** found ");
				break;
			}

		}

	}
}
