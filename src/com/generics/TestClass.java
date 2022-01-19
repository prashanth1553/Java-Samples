package com.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TestClass {

	public static void main(String args[]) {

		BaseEntity<String> entity = new BaseEntity<>();
		entity.setItem("test");
		entity.addItem("abs");
		System.out.println(entity.getItem());
		System.out.println(entity.getList());

		Sub1<Integer> integer = new Sub1<>();
		integer.setItem("sub class");
		System.out.println(integer.getItem());

		entity = integer;
		System.out.println(entity.getItem());

		// test case 2 generics
		List<Child> buildings = new ArrayList<>();
		buildings.add(new Child());
		// paintAllBuildings(buildings);

	}

	public void paintAllBuildings(List<? extends Parent> buildings) {
		// buildings.forEach(Parent::getName);

	}

	public static <T, G> List<G> fromArrayToList(T[] a, Function<T, G> mapperFunction) {
		return Arrays.stream(a).map(mapperFunction).collect(Collectors.toList());
	}
}
