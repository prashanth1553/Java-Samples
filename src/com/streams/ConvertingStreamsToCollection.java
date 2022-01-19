package com.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ConvertingStreamsToCollection {

	public static void main(String args[]) {

		Stream<Integer> intStream = Stream.of(1, 2, 3, 4);
		List<Integer> intList = intStream.collect(Collectors.toList());
		System.out.println(intList); // prints [1, 2, 3, 4]

		intStream = Stream.of(1, 2, 3, 4); // stream is closed, so we need to create it again
		Map<Integer, Integer> intMap = intStream.collect(Collectors.toMap(i -> i, i -> i + 10));
		System.out.println(intMap); // prints {1=11, 2=12, 3=13, 4=14}

		Stream<Integer> intStream1 = Stream.of(1, 2, 3, 4);
		Integer[] intArray = intStream1.toArray(Integer[]::new);
		System.out.println(Arrays.toString(intArray)); // prints [1, 2, 3, 4]

		intStream = Stream.of(1, 2, 3, 4, 1, 2, 3, 4, 5); // stream is closed, so we need to create it again
		Map<Integer, Long> count = intStream.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(count);

		String s = Stream.of().map(i -> "" + i).collect(Collectors.joining(","));
		System.out.println("".equals(s));

		System.out.println("Unique = "
				+ Stream.of("A", "B", "C", "B", "A", "B", "A", "D").distinct().collect(Collectors.joining(",")));

		List<String> list2 = Arrays.asList("adf", "bcd", "abc", "hgr", "jyt", "edr", "biu");
		System.out.println(list2.stream().collect(StringBuilder::new,
				(StringBuilder ss, String s1) -> ss.append(s1 + ","), (ss1, ss2) -> ss1.append(ss2)));

		int ar[] = { 0, 0 };
		System.out.println("any match = " + Arrays.stream(ar).anyMatch(ii -> ii != 0));

		Arrays.stream(ar).boxed().collect(Collectors.toList());

		intList.stream().reduce((a, b) -> {
			if (a >= b) {
				return a;
			}
			return b;
		});
		

	}

}
