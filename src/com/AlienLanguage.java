package com;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AlienLanguage implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String args[]) {

		String words[] = { "baa", "abcd", "abca", "cab", "cad" }; // b, d, a, c

		List<Character> chars = new ArrayList<>();
		for (int i = 0; i < words.length - 1; i++) {

			String w1 = words[i];
			String w2 = words[i + 1];
			int minL = Math.min(w1.length(), w2.length());
			for (int j = 0; j < minL; j++) {

				char c1 = w1.charAt(j);
				char c2 = w2.charAt(j);
				if (!chars.contains(c1)) {

					chars.add(c1);
				}
				if (c1 != c2) {
					break;
				}

			}

		}

		System.out.println(chars.toString());

	}
}
