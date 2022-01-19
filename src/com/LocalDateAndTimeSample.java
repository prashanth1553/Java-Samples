package com;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class LocalDateAndTimeSample {

	public static void main(String args[]) {

		System.out.println(Date.from(LocalDateTime.of(2020, 10, 14, 8, 8).atZone(ZoneId.systemDefault()).toInstant()).getTime());
		System.out.println(Date.from(LocalDateTime.of(2020, 10, 14, 8, 8).atZone(ZoneId.systemDefault()).toInstant()));
	}
}
