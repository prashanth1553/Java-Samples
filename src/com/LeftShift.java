package com;

import java.util.Scanner;

public class LeftShift {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		String[] nd = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nd[0]);

		int d = Integer.parseInt(nd[1]);

		int[] a = new int[n];

		String[] aItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int aItem = Integer.parseInt(aItems[i]);
			a[i] = aItem;
		}
		int[] b = new int[n];
		for (int i = 0; i < n; i++) {
			b[i] = a[i];
		}
		int l = d % n;
		if (l > 0) {
			//  array[(i + n - d) % n] = getArray [i];
			for (int i = 0; i < n; i++) {
				int s = i - l < 0 ? ((n) - (-1) * (i - l)) : i - l;
				a[s] = b[i];
			}

		}

		String space = "";
		for (int i = 0; i < n; i++) {
			System.out.print(space + a[i]);
			space = " ";
		}

		scanner.close();
	}
}
