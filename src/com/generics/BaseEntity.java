package com.generics;

import java.util.ArrayList;
import java.util.List;

public class BaseEntity<T> {

	private List<T> list = new ArrayList<>();
	private T item;

	public BaseEntity() {

	}

	public BaseEntity(List<T> list, T item) {
		super();
		this.list = list;
		this.item = item;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public T getItem() {
		return item;
	}

	public void setItem(T item) {
		this.item = item;
	}

	public void addItem(T item) {
		list.add(item);
	}
	
	public T getType() {
		return item;
	}
}
