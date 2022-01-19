package com.threads.sleepingbarber;

public class Barber {

	public void cutHair() {
		System.out.println("Barber: Cutting Hair --- " + Thread.currentThread().getName());
	}
}
