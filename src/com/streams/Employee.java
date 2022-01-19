package com.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Employee implements Comparable<Employee> {

	private String name;
	private String city;
	private int id;
	private double salary;

	public Comparator<Employee> ComparatorBYSalary = (Employee a, Employee b) -> {
		return Double.compare(a.salary, b.salary);
	};

	public Employee(String name, int id, double salary) {
		super();
		this.name = name;
		this.id = id;
		this.salary = salary;
	}

	public Employee(int id, String name, String city) {
		super();
		this.name = name;
		this.id = id;
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public static List<Employee> getTestData() {
		Random r = new Random();
		List<Employee> employees = new ArrayList<Employee>();
		for (int i = 0; i < 10; i++) {

			employees.add(new Employee("", r.nextInt(), Math.random()));

		}

		return employees;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public int compareTo(Employee o) {
		if (name.compareTo(o.name) == 0) {
			return Double.compare(salary, o.salary);
		}
		return name.compareTo(o.name);
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", city=" + city + ", id=" + id + ", salary=" + salary
				+ ", ComparatorBYSalary=" + ComparatorBYSalary + "]";
	}
	
	
}
