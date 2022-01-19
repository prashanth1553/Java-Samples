package com.threads.sleepingbarber;

public class Customer {
	private String name;

	public Customer(String name) {
		this.name = name;
	}

	public void enter() {
		System.out.println("Customer: " + name + " Enters the shop --- " + Thread.currentThread().getName());
	}

	public void getHairCut() {
		System.out.println("Customer: " + name + " Getting Haircut --- " + Thread.currentThread().getName());
	}

	public void leave() {
		System.out.println("Customer: " + name + " Leaves the shop --- " + Thread.currentThread().getName());
	}

}
