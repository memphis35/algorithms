package com.company.queue;

import com.company.exceptions.EmptyQueueException;
import com.company.exceptions.FullQueueException;

public class CountlessQueue {
	
	private final int MAX_SIZE;
	private int[] queue;
	private int front, rear;

	public CountlessQueue(int size) {
		MAX_SIZE = size;
		queue = new int[size];
		front = 0;
		rear = -1;
	}
	
	void insert(int element) throws FullQueueException {
		if (!isFull()) {
			rear = (rear >= MAX_SIZE - 1) ? -1 : rear;
			queue[++rear] = element;
		} else {
			throw new FullQueueException("Queue is full.");
		}
	}
	
	int remove() throws EmptyQueueException {
		if (!isEmpty()) {
		int element = queue[front];
		queue[front] = 0;
		front = (front >= MAX_SIZE) ? 0 : front;
		return element; 
		} else {
			throw new EmptyQueueException;
		}
	}
	
	int peek() {
		return queue[front];
	}
	
	private boolean isEmpty() {
		return front - 1 == rear || front + MAX_SIZE - 1 == rear;
	}
	
	private boolean isFull() {
		return front - 2 == rear || front + MAX_SIZE - 2 == rear;
	}
	
	public int size() {
		return (front < rear) ? rear - front + 1: MAX_SIZE - (front - rear + 1);
	}

}