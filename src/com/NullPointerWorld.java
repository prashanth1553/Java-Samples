package com;

import java.util.Collections;
import java.util.List;

public class NullPointerWorld {

	public static void main(String args[]) {
		NullPointerWorld obj = new NullPointerWorld();
		
		obj.forLoopNullPointerTest();

	}

	public void forLoopNullPointerTest() {
		List<Integer> loop = null;
		System.out.println(Collections.unmodifiableCollection(loop));
		for (Integer i : loop) {
			System.out.println(i);
		}

		
	}

}
