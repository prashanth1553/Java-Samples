package com.exceptions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ReturnException {

	public static void main(String args[]) {
		returnException();
		System.out.println("After exception");

		String[] ar = { "1", "2" };
		List<String> ar1 = new ArrayList<>(Arrays.asList(ar));

		Stream st = Stream.iterate("", i -> i + "x");
		System.out.println(st.limit(3).map(i -> i + "y").collect(Collectors.toList()));

		IntStream it = IntStream.iterate(0, i -> i + 1);

		System.out.println(it.limit(3).boxed().collect(Collectors.toList()));

	}

	public static Exception returnException() {

		return new Exception();
	}

}
