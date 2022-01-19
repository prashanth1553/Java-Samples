package com;

public class TimeBazar {

	public static void main(String args[]) {

		StringBuilder input = new StringBuilder("512345678901");
		while (input.length() > 1) {
			StringBuilder temp = new StringBuilder();
			for (int i = 1; i < input.length(); i++) {
				temp.append(""
						+ (Character.getNumericValue(input.charAt(i - 1)) + Character.getNumericValue(input.charAt(i)))
								% 10);

			}
			input = temp;
		}

		System.out.println(input);
	}
}
