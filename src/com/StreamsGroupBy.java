package com;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsGroupBy {

	public static void main(String args[]) {

		String s = "jack has 4 white  , 5 red, 4 blue, 3 black, 5 green, 7 blue, 10 yellow ballons";

		List<Integer> list = Arrays.stream(s.split(" ")).filter(a -> {
			try {
				Integer.valueOf(a);
				return true;
			} catch (Exception e) {

			}
			return false;
		}).map(a -> Integer.valueOf(a)).collect(Collectors.toMap(i -> i, j -> 1, (ii, jj) -> ii + jj)).entrySet()
				.stream().filter(e -> e.getValue().equals(1)).map(e -> e.getKey()).collect(Collectors.toList());
		System.out.println(list);

		list = Arrays.stream(s.split(" ")).flatMap(ss -> {
			try {
				return Stream.of(Integer.valueOf(ss));
			} catch (NumberFormatException excep) {

			}
			return Stream.empty();
		}).collect(Collectors.toMap(Function.identity(), j -> 1, (aa, bb) -> aa + bb)).entrySet().stream()
				.filter(e -> e.getValue() == 1).map(e -> e.getKey()).collect(Collectors.toList());
		System.out.println(list);

	}

}
