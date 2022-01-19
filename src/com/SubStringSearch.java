package com;

public class SubStringSearch {

	public int searh(String input, String key) {

		for (int i = 0; i < input.length(); i++) {

			int j = 0;
			for (; j < key.length() && i + j < input.length(); j++) {

				if (input.charAt(i + j) != key.charAt(j)) {
					break;
				}

			}
			if (j == key.length()) {
				return i;
			}

		}

		return -1;
	}
	
	public static void main(String args []) {
		SubStringSearch obj = new SubStringSearch();
		System.out.println(" "+obj.searh("prashanth", "rashanth"));
		
	}
}
