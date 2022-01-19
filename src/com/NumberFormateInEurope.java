package com;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class NumberFormateInEurope {

	public static void main(String args[]) throws ParseException {

		String text = "-1.234567";
		NumberFormat nf_in = NumberFormat.getNumberInstance(Locale.GERMANY);
		double val = nf_in.parse(text).doubleValue();
		System.out.println(val);
		
		System.out.println("US "+ NumberFormat.getNumberInstance(Locale.US).parse(text).doubleValue());

		NumberFormat nf_out = NumberFormat.getNumberInstance(Locale.UK);
		nf_out.setMaximumFractionDigits(3);
		String output = nf_out.format(val);
		System.out.println(output);
	}
}
