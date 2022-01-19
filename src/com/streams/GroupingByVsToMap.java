package com.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class GroupingByVsToMap {

	public static void main(String args[]) {

		// sorting array
		int array1[] = { 1, -4, 0, 0, 5, -5, 1, 0, -2, 4, -4, 1, -1, -4, 3, 4, -1, -1, -3 };
		Arrays.sort(array1);
		System.out.println(Arrays.toString(array1));

		ArrayList<Integer> numbersList = new ArrayList<Integer>();
		numbersList.add(2147483647);
		numbersList.add(-2147483648);
		numbersList.add(-2147483648);
		numbersList.add(0);
		numbersList.add(1);

		// counting and creating map
		List<Employee> list = new ArrayList();
		Map<Integer, Integer> keyToCount = list.stream().collect(Collectors.toMap(Employee::getId, i -> 1,
				(existing, replacement) -> (existing + 1), LinkedHashMap::new));

		// first non-repeating character
		Character array[] = { '1', '4', '1', '4', '2' };
		Character nonR = Arrays.stream(array)
				.collect(
						Collectors.toMap(j -> j, i -> 1, (existing, replacement) -> (existing + 1), LinkedHashMap::new))
				.entrySet().stream().filter(entry -> entry.getValue() == 1).findFirst().orElse(null).getKey();
		System.out.println("nonR ====== " + nonR);

		// with supplier
		Supplier<LinkedHashMap<Integer, Integer>> supplier = () -> new LinkedHashMap<>();
		list.stream().collect(Collectors.toMap(Employee::getName, i -> 1, (existin, newV) -> existin + 1,
				() -> new LinkedHashMap<>()));

		// groupingBy sample
		Map<Character, List<Character>> grouped = Arrays.stream(array)
				.collect(Collectors.groupingBy(i -> i, HashMap::new, Collectors.toList()));
		grouped.entrySet().stream().sorted((a, b) -> Character.compare(a.getKey(), b.getKey()));

		// grouping By Chunk size
		final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
		final int chunkSize = 3;
		final AtomicInteger counter = new AtomicInteger();
		System.out.println("counter" + counter.get());
		final Map<String, List<Integer>> result = numbers.stream().collect(Collectors.groupingBy(
				it -> "mpIds" + (counter.getAndIncrement()) / chunkSize, LinkedHashMap::new, Collectors.toList()));

		numbers.stream()
				.collect(Collectors.groupingBy(((ab) -> counter.getAndIncrement() % chunkSize), Collectors.toList()));

		// identity function
		numbersList.stream()
				.collect(Collectors.toMap(Function.identity(), i -> 1, (x, y) -> x + y, LinkedHashMap::new));

		// flat map example
		Map<String, List<String>> people = new HashMap<>();
		people.put("John", Arrays.asList("555-1123", "555-3389"));
		people.put("Mary", Arrays.asList("555-2243", "555-5264"));
		people.put("Steve", Arrays.asList("555-6654", "555-3242"));

		List<String> phones = people.values().stream().flatMap(Collection::stream).collect(Collectors.toList());
		List<List<String>> streaOfR = new ArrayList<>();

		streaOfR.stream().flatMap(s -> s.stream());

		// flatmap, sorting the hashmap by value
		List<Empoyee> employees = new ArrayList<>();
		employees.add(new Empoyee(Arrays.asList("a", "b", "c")));
		employees.add(new Empoyee(Arrays.asList("a", "bb", "cc")));
		employees.add(new Empoyee(Arrays.asList("a", "b", "ccc")));

		Map<String, Integer> articlesSold = employees.stream().flatMap(ss -> ss.getNames().stream())
				.collect(Collectors.toMap(aa -> aa, bb -> 1, (ab, ba) -> ab + ba, LinkedHashMap::new)).entrySet()
				.stream().limit(5).collect(Collectors.toMap(etr -> etr.getKey(), etr -> etr.getValue()));

		List<Entry<String, Integer>> sortedMap = articlesSold.entrySet().stream()
				.sorted((ab, b) -> Integer.compare(b.getValue(), ab.getValue())).collect(Collectors.toList());

		Map<String, Integer> articlesSold2 = sortedMap.stream()
				.collect(Collectors.toMap(ii -> ii.getKey(), jj -> jj.getValue(), (aa, bb) -> aa, LinkedHashMap::new));

		System.out.println("sortedMap == " + sortedMap);
		System.out.println("articlesSold2 sorted map == " + articlesSold2);

		employees.stream().flatMap(ss -> ss.getNames().stream())
				.collect(Collectors.toMap(aa -> aa, bb -> 1, (ab, ba) -> ab + ba, LinkedHashMap::new)).entrySet()
				.stream().sorted((ab, b) -> Integer.compare(b.getValue(), ab.getValue())).collect(Collectors.toList());

		// summarizing the list
		IntSummaryStatistics st = Arrays.stream(array1).boxed().collect((Collectors.summarizingInt(ab -> ab)));

		// merging list of list
		List<List<Integer>> listOfList = Arrays.asList(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(7, 8, 9, 10));
		listOfList.stream().collect(Collectors.toMap(ii -> ii.size(),
				jj -> jj.stream().filter(ii -> ii % 2 == 0).collect(Collectors.toList()), (iia, jja) -> {
					iia.addAll(jja);
					return iia;
				}));

		System.out.println();

		// merging list of list with flatMapping
		Map<Integer, List<Integer>> map = listOfList.stream().collect(Collectors.groupingBy(Collection::size,
				Collectors.flatMapping(l -> l.stream().filter(i -> i % 2 == 0), Collectors.toList())));

		Map<Integer, Integer> counterTest = new TreeMap<>((i, j) -> Integer.compare(j, i));
		for (Integer i : array1) {
			counterTest.compute(i, (k, v) -> Objects.isNull(v) ? 1 : v + 1);
			// counterTest.computeIfAbsent(i, j -> 0);
			// counterTest.computeIfPresent(i, (k, v) -> v + 1);
		}
		System.out.println(counterTest.toString());
		
		System.out.println(Character.getNumericValue('1'));

	}

	static class Empoyee {

		public List<String> companies;

		public Empoyee(List<String> names) {
			this.companies = names;
		}

		public List<String> getNames() {
			return companies;
		}
	}

	class SupplierImple implements Supplier<Integer> {

		@Override
		public Integer get() {

			Supplier<Integer> s = () -> 1;
			s = () -> {
				return 1;
			};

			return null;
		}

	}
}
