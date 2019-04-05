package com.code.hackerrank.datastructure;

public class DynamicArray<T> {

	private Object[] data;
	private int size;
	
	public DynamicArray() {
		data = new Object[10];
		size = 0;
	}
	
	public DynamicArray(int length) {
		data = new Object[length];
		size = 0;
	}
	
	@SuppressWarnings("unchecked")
	public T get(int index) {
		return (T)data[index];
	}
	
	public void add(T item) {
		if(size == data.length) {
			resizeArray();
		}
		size = size + 1;
		data[size] = item;
	}
	
	private void resizeArray() {
		Object[] bigger = new Object[2*size];
		for(int i=0; i<size; i++) {
			bigger[i] = data[i];
		}
		data = bigger;
	}
	
	public int size() {
		return size;
	}
	
}
