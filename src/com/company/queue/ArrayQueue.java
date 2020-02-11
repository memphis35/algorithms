package com.company.queue;

public class ArrayQueue extends AbstractQueue {
	
	public ArrayQueue(int size) {
		super(size);
		queue = new int[size];
		count = 0;
	}

	@Override
	void add(int element) {
		super.add(element);
		count++;
	}

	@Override
	int delete() {
		count--;
		return super.delete();
	}
}