package com;

public class KMP {

	public int indexOf(String s, String p) {
		int N = s.length(), M = p.length();
		int dfa[][] = new int[256][M];

		dfa[p.charAt(0)][0] = 1;
		for (int i = 1, X = 0; i < M; i++) {

			for (int c = 0; c < 256; c++) {

				dfa[c][i] = dfa[c][X];
			}
			dfa[p.charAt(i)][i] = i + 1;
			X = dfa[p.charAt(i)][X];

		}

		return N;
	}
}
