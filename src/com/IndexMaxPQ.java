package com;

public class IndexMaxPQ<Key extends Comparable<Key>> {

	private int pq[];
	private int qp[];
	private Key items[];
	private int n;

	public IndexMaxPQ(int initialc) {
		pq = new int[initialc];
		qp = new int[initialc];
		items = (Key[]) new Comparable[initialc + 1];
		for (int i = 0; i <= initialc; i++)
			qp[i] = -1;

	}

	public void insert(int index, Key key) {
		if (contains(index)) {
			throw new IllegalArgumentException("Item already exists");
		}
		qp[index] = ++n;
		pq[n] = index;
		items[index] = key;
	}

	public boolean contains(int index) {
		return qp[index] == -1;
	}

	private void exchange(int i, int j) {
		int t = pq[i];
		pq[i] = pq[j];
		pq[j] = t;
		qp[pq[i]] = i;
		qp[pq[j]] = j;
	}

	private int less(int i, int j) {
		return items[pq[i]].compareTo(items[pq[j]]);
	}
}
