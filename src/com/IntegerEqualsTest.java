package com;

public class IntegerEqualsTest {

	public static void main(String args[]) {
		Integer a = 130;
		Integer b = 130;
		System.out.println(a == b);

		Integer c = Integer.valueOf(130);
		Integer d = Integer.valueOf(130);
		System.out.println(c == d);
		
		// -128 to 127	
		Integer e = Integer.valueOf(126);
		Integer f = Integer.valueOf(126);
		Integer g = new Integer(126);
		System.out.println(e ==f);
		System.out.println(g ==f);
		
		
		String str1 = "hello";
		String str2 = "hello";
		System.out.println(str1 == str2); //prints true

		String str3 = new String("hello");
		String str4 = new String("hello");

		System.out.println(str1 == str3); //prints false
		System.out.println(str3 == str4); //prints false 
		
		str3 = str3.intern();
		str4 = str4.intern();
		
		
		System.out.println(str1 == str3); //prints true
		System.out.println(str3 == str4); //prints true 
	}
}
