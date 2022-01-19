package com.protectedtest;

import java.util.Collections;

public class Parent {

	private static final String TEST_STATIC = "Parent";
	public int name = 10;
	private String childName;

	protected int getName() {
		return name;
	}

	public String testStatic() {
		return TEST_STATIC;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((childName == null) ? 0 : childName.hashCode());
		result = prime * result + name;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Parent other = (Parent) obj;
		if (childName == null) {
			if (other.childName != null)
				return false;
		} else if (!childName.equals(other.childName))
			return false;
		if (name != other.name)
			return false;
		return true;
	}

}
