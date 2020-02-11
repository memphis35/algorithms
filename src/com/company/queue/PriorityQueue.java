package com.company.queue;

import com.company.exceptions.EmptyQueueException;
import com.company.exceptions.FullQueueException;

public class PriorityQueue {
	
	private final int MAX_SIZE;
	private int[] queue;
	private int qElements;
	
	public PriorityQueue(int size) {
		MAX_SIZE = size;
		queue = new int[size];
		qElements = 0;
	}
	
	void insert(int element) throws FullQueueException {
		if (!isFull()) {
			int i = qElements;
			while (element < queue[i - 1]) {
				queue[i] = queue[i - 1];
			}
			queue[i] = element;
			qElements++;
		} else {
			throw new FullQueueException("Queue is full.");
		}
	}
	
	int remove() throws EmptyQueueException {
		if (!isEmpty()) {
		int element = queue[0];
		int i = 0;
		while (i < qElements) {
			queue[i + 1] = queue[i];
			i++;
		}
		qElements--;
		return element;
		} else {
			throw new EmptyQueueException("Queue is empty.");
		}
	}
	
	int peek() {
		return queue[0];
	}
	
	private boolean isEmpty() {
		return qElements == 0;
	}
	
	private boolean isFull() {
		return qElements == MAX_SIZE;
	}
	
	public int size() {
		return qElements;
	}

}