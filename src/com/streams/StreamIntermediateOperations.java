package com.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamIntermediateOperations {

	public void filterSample() {

		List<Integer> myList = new ArrayList<>();

		for (int i = 0; i < 100; i++) {
			myList.add(i);
		}

		Stream<Integer> sequentialStream = myList.stream();

		Stream<Integer> highNums = sequentialStream.filter(p -> p > 90); // filter numbers greater than 90
		highNums.forEach(p -> System.out.print(p + " "));
	}

	public void map() {

		Stream<String> names = Stream.of("aBc", "d", "ef");
		System.out.println(names.map(s -> {
			return s.toUpperCase();
		}).collect(Collectors.toList()));
	}
	
	
}
