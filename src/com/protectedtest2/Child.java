package com.protectedtest2;

import java.util.TreeSet;

import com.protectedtest.Parent;

public class Child extends Parent {

	public int name = test();
	private static int vb = 10;

	private static final String TEST_STATIC = "Child";

	public static void main(String args[]) {
		Parent p = new Parent();
		Child c = new Child();
		System.out.println("with child object == " + c.testStatic());
		Parent p1 = c;
		System.out.println("Calling with parent reference = " + p1.testStatic());

		c.getName();
		// p.getName(); -- not able to access protected method with Parent object

		Parent c1 = new Child();

		System.out.println("variable with parent reference  = " + c1.name);
		TreeSet<Integer> treeSet;
		
	}

	@Override
	public String testStatic() {
		return TEST_STATIC;
	}

	private int test() {
		return vb;
	}
	
	
}
