package com;

import java.util.Scanner;

public class SplittingString {

	public static int splitString(String input) {
		int length = input.length();
		if (isPerfectString(input)) {
			return 0;
		}
		if (length % 2 != 0 && length != 1) {
			return -1;
		}
		int cuts = 0;
		cuts++;
		String left = input.substring(0, length / 2);
		String right = input.substring(length / 2, length);
		int leftAns = splitString(left);
		int rightAns = splitString(right);
		if (leftAns == -1 && rightAns != -1) {
			return cuts + rightAns;
		} else if (leftAns != -1 && rightAns == -1) {
			return cuts + leftAns;
		} else if (leftAns != -1 && rightAns != -1) {
			return cuts + Math.min(leftAns, rightAns);
		}
		return -1;
	}

	public static boolean isPerfectString(String input) {
		char c = input.charAt(0);
		for (int i = 1; i < input.length(); i++) {
			if (c != input.charAt(i)) {
				return false;
			}
		}
		return true;

	}

	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int t = Integer.parseInt(s.nextLine().trim());
		for (int i = 0; i < t; i++) {
			System.out.println(splitString(s.nextLine().trim()));
		}

	}
}
