package com.company.queue;

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
	    if ((front == 0 && rear == maxSize - 1) || (front - 1 == rear)) return 0;
        return (front <= rear) ? rear - front + 1 : (maxSize - front) + (rear + 1);
    }
}