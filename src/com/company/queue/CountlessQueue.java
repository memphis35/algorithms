package com.company.queue;

import java.util.Arrays;

public class CountlessQueue extends AbstractQueue {

	public CountlessQueue(int size) {
        super(size);
        maxSize = size + 1;
        queue = new int[maxSize];
    }

	@Override
    boolean isEmpty() {
        return front - 1 == rear || rear - front == maxSize - 1;
    }

	@Override
    boolean isFull() {
        return front - 2 == rear || rear - front == maxSize - 2;
    }

	@Override
    int size() {
        return (front <= rear && (rear - front < maxSize - 1)) ? rear - front + 1 : maxSize - (rear - front + 1);
    }

    @Override
	void display() {
		System.out.println(Arrays.toString(queue));
	}

}