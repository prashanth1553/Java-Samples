package com.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MaxElement {

	public static void main(String args[]) {

		Stream.of(new Employee("", 1, 1)).max((t1, t2) -> Double.compare(t1.getSalary(), t2.getSalary()));

		Employee e = new Employee("", 1, 1);

		AtomicBoolean ab = new AtomicBoolean();

		// Stream.of(t)

		List<Employee> data = Arrays.asList(new Employee(1, "sriram", "Rjy"), new Employee(1, "auresh", "hyd"),
				new Employee(1, "ramesh", "Cha"));

		// Collections.sort(data);

		data.sort(Comparator.comparing(Employee::getId).thenComparing(Employee::getName));
		data.sort((a, b) -> a.compareTo(b));
		data.forEach(System.out::println);

		List<String> stringList = new ArrayList<>();
		stringList.add("abc");
		stringList.add("dbc");
		String result = stringList.stream().collect(Collectors.joining("; "));
		System.out.println(result);

	}

	static class Zalando {

		public List<String> articles;

		public Zalando(List<String> articles) {
			this.articles = articles;
		}

		public List<String> getArticles() {
			return articles;
		}

	}
}
