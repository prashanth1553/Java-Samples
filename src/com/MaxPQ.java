package com;

import java.util.Arrays;

public class MaxPQ<Key extends Comparable<Key>> {

	private Key items[];
	int n;

	public MaxPQ(int size) {
		items = (Key[]) new Object[size + 1];
	}

	public boolean isEmpty() {
		return n == 0;
	}

	public void insert(Key item) {

		items[++n] = item;
		swim(n);

	}

	public Key deleteMax() {

		Key item = items[1];

		items[1] = items[n--];
		sink(1);
		items[n + 1] = null;
		return item;

	}

	private void swim(int k) {

		while (k > 1 && isLess(k / 2, k)) {
			exchange(k, k / 2);
			k = k / 2;

		}

	}

	private void sink(int k) {

		while (2 * k <= n) {

			int j = 2 * k;
			if (j + 1 <= n && isLess(j, j + 1)) {
				j = j + 1;
			}

			if (isLess(k, j)) {
				exchange(k, j);
				k = j;
			} else {
				break;
			}

		}

	}

	private boolean isLess(int i, int j) {
		return items[i].compareTo(items[j]) < 0;
	}

	private void exchange(int i, int j) {
		Key t = items[i];
		items[i] = items[j];
		items[j] = t;
		
		String a[] = {};
		Arrays.sort(a);

	}
}
