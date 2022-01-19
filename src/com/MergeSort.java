package com;

public class MergeSort {

	private void sort(int lo, int hi, Comparable array[], Comparable aux[]) {
		if (lo >= hi) {
			return;
		}
		int m = lo + (hi - lo) / 2;
		sort(lo, m, array, aux);
		sort(m + 1, hi, array, aux);

	}

	private void merge(int lo, int hi, int m, Comparable array[], Comparable aux[]) {

		for (int j = lo; j <= hi; j++) {
			aux[j] = array[j];
		}
		int i = lo, j = m + 1;
		for (int k = lo; k <= hi; k++) {
			if (isLess(j, i, array)) {
				array[k] = aux[j];
				j++;
			} else if (j > k) {
				array[k] = array[i];
				i++;
			} else {
				array[k] = array[j];
				j++;
			}

		}

	}

	private boolean isLess(int i, int j, Comparable array[]) {
		return array[i].compareTo(j) < 0;
	}

	private void exchange(int i, int j, Comparable array[]) {
		Comparable t = array[i];
		array[i] = array[j];
		array[j] = t;
	}

	public void sort(Comparable[] a) {
		int n = a.length;
		for (int ln = 1; ln < n; ln *= 2) {
			for (int i = 0; i < n - ln; i += ln + ln) {
				int m = i + ln - 1;
				int hi = Math.min(i + ln + ln - 1, n - 1);
				merge(i, hi, m, a, a);
			}

		}
	}
}
