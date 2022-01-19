package com.inheritance;

public class Parent {

	public Parent(Parent copy) {

	}

	public Parent() {

	}

	protected static final String PARENT = "PARENT";

	{
		System.out.println("instance block");
	}
	public String inheritanceTest = "Paretn";

	public static void staticTest() {
		System.out.println("Parent");
	}

	void getParent() {
		System.out.println(PARENT);
	}
}
