package com;

public class InnerClasses {

	static {
	}

	static void testInner() {
		class Test {

			class Test1 {

			}
		}
		Test obj = new Test();

	}
}
