package com;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class MainMethod {

	private static final Date RPD1 = Date
			.from(LocalDateTime.of(2020, 4, 27, 9, 49).atZone(ZoneId.systemDefault()).toInstant());;
	private static final Date RDD1 = Date
			.from(LocalDateTime.of(2020, 4, 28, 10, 49).atZone(ZoneId.systemDefault()).toInstant());;
	private static final Date RPD = new Date(119, 8, 9, 10, 0);
	private static final Date RDD = new Date(119, 8, 10, 12, 0);

	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {

		System.out.println((30 * 1.0) / 4);

		// System.out.println("P" == new String("P"));
		System.out.println(Integer.MAX_VALUE + Integer.MAX_VALUE);
		// old solution
		System.out.println((long) Integer.MAX_VALUE + Integer.MAX_VALUE);
		System.out.println(Long.sum(Integer.MAX_VALUE, Integer.MAX_VALUE));

		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(1);
		a.add(2);
		a.ensureCapacity(12);

		String s = "123Z";
		System.out.println(Character.getNumericValue(s.charAt(3)));

		System.out.println((int) "ABC".charAt(0));

		MainMethod obj = new MainMethod();
		List<Integer> list = Arrays.asList(699, 254);
		System.out.println(obj.firstMissingPositive(list));

		obj.longTest(1, 2);

		AlienLanguage alienLanguage = (AlienLanguage) Class.forName("com.AlienLanguage").newInstance();
		System.out.println(alienLanguage);

		System.out.println((int) 'A');

		String s1 = "abc cc  ,dcv,      ax";
		String apl[] = s1.split("\\s*,\\s*");
		System.out.println("s1 == " + Arrays.toString(s1.split("\\s*,\\s*")));

	}

	private void longTest(long a, long b) {
		System.out.println("a , b");
	}

	private void longTest(long... a) {
		System.out.println("var args");
	}

	private static int binarySearch(int lo, int hi, int[] items, int element, int rankCount) {
		int mid = 0;
		while (lo <= hi) {
			mid = lo + (hi - lo) / 2;
			if (element < items[mid]) {
				hi = mid - 1;
			} else if (element > items[mid]) {
				lo = mid + 1;
			} else {
				return rankCount + 1 - mid;
			}

		}
		int r = hi;

		if (r > rankCount) {
			r = 1;
		} else if (r < 0) {
			r = rankCount + 1 + 1;
		} else {
			r = rankCount + 1 - r;
		}
		return r;
	}

	public static String getPCvalueFromUserNameId(String nameId) {
		// input: teste-ga@de001.itgr.net output: de001\teste-ga
		int firstPeriodIndex = nameId.indexOf('@')
				+ nameId.substring(nameId.indexOf('@'), nameId.length()).indexOf('.');
		String firstPart = nameId.substring(nameId.indexOf('@') + 1, firstPeriodIndex);
		String secondPart = nameId.substring(0, nameId.indexOf('@'));
		return firstPart + "\\" + secondPart;
	}

	public static int phi(int n) {
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

	private static final Scanner scanner = new Scanner(System.in);

	public static void main3(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */
		int t = scanner.nextInt();
		for (int i = 0; i < t; i++) {
			int factorial = scanner.nextInt();
			int array[] = new int[500];
			array[0] = 1;
			int l = 1;
			for (int f = 1; f <= factorial; f++) {
				l = mulitPly(array, f, l);
			}
			int zerosCount = 0;
			for (int z = 0; z < array.length; z++) {
				if (array[z] == 0) {
					zerosCount++;
				} else {
					break;
				}
			}
			System.out.println(zerosCount);

		}
	}

	public static int mulitPly(int array[], int multiplier, int l) {
		int carry = 0;
		for (int i = 0; i < l; i++) {
			int r = carry + (array[i] * multiplier);
			array[i] = r % 10;
			carry = r / 10;

		}

		while (carry != 0) {
			array[l++] = carry % 10;
			carry = carry / 10;
		}
		return l;

	}

	private boolean sum(int i, int array[], int sum, int n) {
		if (i >= array.length) {
			return false;
		}
		if (sum + array[i] == n) {
			return true;
		}
		return sum(i + 1, array, sum + array[i], n) || sum(i + 1, array, sum, n);
	}

	public int removeDuplicates1(ArrayList<Integer> a) {
		if (a.size() <= 1) {
			return a.size();
		}
		int p1 = 0, p2 = 1;
		while (p1 < p2 && p2 < a.size()) {
			if (a.get(p1).equals(a.get(p2))) {
				p2++;
			} else {
				a.set(p1 + 1, a.get(p2));
				p1++;
				p2++;
			}

		}
		return p1 + 1;
	}

	public int removeDuplicates(ArrayList<Integer> a) {
		if (a.isEmpty()) {
			return 0;
		}
		if (a.size() <= 2) {
			return a.size();
		}
		int left = 2;
		for (int right = 2; right < a.size(); right++) {
			if (!a.get(left - 2).equals(a.get(right))) {
				a.set(left, a.get(right));
				left++;
			}
		}
		return left;

	}

	public int solve(ArrayList<Integer> A, int B) {
		int count = 0;
		int p1 = 0, p2 = 0;
		int sum = 0;
		while (p2 < A.size()) {
			sum += A.get(p2);
			if (sum < B) {
				count += (p2 - p1 + 1);
				p2++;
			} else {
				sum -= A.get(p2);
				if (p1 != p2) {
					sum -= A.get(p1);
					p1++;
				} else {
					p1++;
					p2++;
				}
			}

		}

		return count;
	}

	public int pow1(int x, int n, int d) {

		int ans = powR(x, n, d);
		if (ans < 0)
			ans = (ans + d) % d;
		return ans;
	}

	public int powR(int x, int n, int d) {
		if (n == 0) {
			return 1;
		}
		if (n == 1) {
			return x % d;
		}
		int halfP = powR(x, n / 2, d);
		if (n % 2 == 0) {
			long r = 1l * halfP * halfP;
			return (int) r % d;
		}
		long r = 1l * halfP * halfP;
		r = r % d;
		r = (r * (x % d)) % d;
		return (int) r;
	}

	public int pow(int x, int n, int d) {
		if (x == 0) {
			return x;
		}
		if (n == 0) {
			return 1;
		}
		int ans = 1, a = x % d;
		while (n != 0) {
			if ((n & 1) == 1) {
				ans = (a * ans) % d;
			}
			long al = (1l * a * a) % d;
			a = (int) al;
			n = n >> 1;
		}
		if (ans < 0) {
			ans = (ans + d) % d;
		}
		return ans;
	}

	public int firstMissingPositive(List<Integer> A) {
		if (A.size() <= 0) {
			return 0;
		}
		int size = A.size();
		int moreThanSize = size + 1;
		for (int i = 0; i < size; i++) {
			if (A.get(i) > size || A.get(i) <= 0) {
				A.set(i, moreThanSize);
			}
		}
		for (int i = 0; i < size; i++) {
			if (A.get(i).equals(1) || i == 204) {
				System.out.println(1);
			}
			if (A.get(i) <= size && A.get(i) > 0) {
				int index = A.get(i) - 1;
				if (A.get(index) > 0) {
					A.set(index, -1 * A.get(index));
				}
			}
		}
		for (int i = 0; i < size; i++) {
			if (A.get(i) > 0) {
				return i + 1;
			}
		}
		return size + 1;
	}

	private static void pega1() {

		Map<Integer, Integer[]> array = new HashMap<>();
		TreeSet<Integer> tre = new TreeSet<>();
		
	}
}
