package com.generics;

import java.util.ArrayList;
import java.util.List;

public class Sub1<T> extends BaseEntity<String> {

	private List<T> list = new ArrayList<>();
	private T item;

	public List<T> getList1() {
		return list;
	}

	public void setList1(List<T> list) {
		this.list = list;
	}

	public T getItem1() {
		return item;
	}

	public void setItem1(T item) {
		this.item = item;
	}
	
	
}
