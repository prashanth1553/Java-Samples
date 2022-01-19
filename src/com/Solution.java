package com;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {

	private static final Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		String[] eAndQ = scan.nextLine().split(" ");
		int queries = Integer.parseInt(eAndQ[1]);
		int elements[] = new int[Integer.parseInt(eAndQ[0])];
		String[] elementsString = scan.nextLine().split(" ");
		for (int i = 0; i < elements.length; i++) {
			elements[i] = Integer.parseInt(elementsString[i]);
		}
		HashMap<Integer, Integer> calculated = new HashMap<>();
		for (int i = 0; i < queries; i++) {
			String[] q = scan.nextLine().split(" ");
			if (q[0].equals("TOTIENT")) {
				totient(elements, Integer.parseInt(q[1]), Integer.parseInt(q[2]), calculated);
			} else {
				int l = Integer.parseInt(q[1]);
				int r = Integer.parseInt(q[2]);
				int m = Integer.parseInt(q[3]);
				for (int mult = l - 1; mult < r; mult++) {
					elements[mult] *= m;
				}

			}

		}

	}

	private static void totient(int elements[], int l, int r, HashMap<Integer, Integer> calculated) {
		int t = 1;
		for (int i = l - 1; i < r; i++) {
			if (calculated.containsKey(elements[i])) {
				t *= calculated.get(elements[i]);
			} else {
				int calculatedV = totient(elements[i]);
				t *= calculatedV;
				calculated.put(elements[i], calculatedV);
			}

		}
		System.out.println(t);
	}

	public static int totient(int n) {
		int result = n;
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				while (n % i == 0)
					n /= i;
				result -= result / i;
			}
		}
		if (n > 1)
			result -= result / n;
		return result;
	}

	static int gcd(int a, int b) {
		if (a == 0)
			return b;
		return gcd(b % a, a);
	}
}
