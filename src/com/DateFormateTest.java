package com;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormateTest {

	public static void main(String args[]) {
		Date dt = new Date();
		DateFormat dateFormat;
		// Date Format LONG constant
		dateFormat = DateFormat.getDateInstance(DateFormat.SHORT, Locale.FRENCH);
		System.out.println("Locale FRENCH = " + dateFormat.format(dt));
		dateFormat = DateFormat.getDateInstance(DateFormat.LONG, Locale.GERMANY);
		System.out.println("Locale GERMANY = " + dateFormat.format(dt));
		dateFormat = DateFormat.getDateInstance(DateFormat.SHORT, Locale.CANADA);
		System.out.println("Locale CANADA = " + dateFormat.format(dt));
		dateFormat = DateFormat.getDateInstance(DateFormat.LONG, Locale.ITALY);
		System.out.println("Locale ITALY = " + dateFormat.format(dt));
		
		System.out.println("*************");
		dateFormat = DateFormat.getDateInstance(DateFormat.SHORT, Locale.ENGLISH);
		System.out.println("Locale ENGLISH = SHORT " + dateFormat.format(dt));
		
		dateFormat = DateFormat.getDateInstance(DateFormat.LONG, Locale.ENGLISH);
		System.out.println("Locale ENGLISH = LONG " + dateFormat.format(dt));
		
		System.out.println("*************");
		dateFormat = DateFormat.getDateInstance(DateFormat.SHORT, Locale.CANADA);
		System.out.println("Locale CANADA = SHORT " + dateFormat.format(dt));
		
		dateFormat = DateFormat.getDateInstance(DateFormat.LONG, Locale.CANADA);
		System.out.println("Locale CANADA = LONG" + dateFormat.format(dt));
	}
}
