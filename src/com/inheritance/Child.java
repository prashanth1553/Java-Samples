package com.inheritance;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Child extends Parent {
	
	public Child() {
		super(null);
	}

	protected static final String PARENT = "Child";
//	private String inheritanceTest = "Child";

	public static void staticTest() {
		System.out.println("Child");
	}

	public static void main(String args[]) {

		Child.staticTest();

		Child ch = new Child();
		ch.staticTest();

		Parent p = ch;
		p.staticTest();

		ch.getParent();

	}

	private int getName() {
		return 1;
	}

	private String getName(String name) {
		return "" + 1;
	}

	private static Integer bestAveragegrade(String[][] testcase) {
		Map<String, Integer> studentToAverage = new HashMap<>();
		Map<String, Integer> studentToOccurence = new HashMap<>();
		for (int i = 0; i < testcase.length; i++) {
			String name = testcase[i][0];
			Integer marks = new Integer(testcase[i][1]);
			if (studentToAverage.get(name) != null) {
				studentToAverage.put(name, studentToAverage.get(name) + marks);
				studentToOccurence.put(name, studentToOccurence.get(name) + 1);
			} else {
				studentToAverage.put(name, marks);
				studentToOccurence.put(name, 1);
			}
		}
		Integer highestAverage = null;
		for (Entry<String, Integer> entry : studentToAverage.entrySet()) {
			String k = entry.getKey();
			Integer v = entry.getValue();
			Integer average = v / studentToOccurence.get(k);
			if (highestAverage == null) {
				highestAverage = average;
			} else if (average > highestAverage) {
				highestAverage = average;
			}
		}
		return highestAverage;
	}

	public String inheritanceTest() {
		return inheritanceTest;
	}
	
	@Override
	public void getParent() {
		// TODO Auto-generated method stub
		super.getParent();
	}
}
