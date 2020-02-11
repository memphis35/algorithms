package com.company.queue;

import com.company.exceptions.EmptyQueueException;
import com.company.exceptions.FullQueueException;

public class ArrayQueue {

	private final int MAX_SIZE;
	private int[] queue;
	private int front;
	private int rear;
	private int count;
	
	public ArrayQueue(int size) {
		MAX_SIZE = size;
		this.queue = new int[size];
		front = 0;
		rear = -1;
		count = 0;
	}
	
	void insert(int number) throws FullQueueException {
		if (!isFull()) {
			rear = (rear < MAX_SIZE - 1) ? rear : -1;
			queue[++rear] = number;
			count++;
		} else {
			throw new FullQueueException("Queue is full.");
		}
	}
	
	int remove() throws EmptyQueueException {
		if (!isEmpty()) {
			int result = queue[front];
			queue[front] = 0;
			count--;
			front = (front < MAX_SIZE) ? front : 0;
			return result; 
		} else {
			throw new EmptyQueueException("Queue is empty.");
		}
	}
	
	int peek() {
		return queue[front];
	}
	
	int size() {
		return count;
	}
	
	boolean isFull() {
		return count == MAX_SIZE;
	}

	boolean isEmpty(){
		return count == 0;
	}
}