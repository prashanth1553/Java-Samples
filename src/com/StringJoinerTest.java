package com;

import java.io.File;
import java.util.StringJoiner;

public class StringJoinerTest {

	public static void main(String args[]) {

		StringJoiner joiner = new StringJoiner(",");
		
		System.out.println("result ==  "+ joiner.toString());
		
		
		System.out.println("\\\\lshare1\\logo\\baker_hughes.png".replace("\\", File.separator));
	}
}
