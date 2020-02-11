package com.company.queue;

public class PriorityQueue extends AbstractQueue {

    public PriorityQueue(int size) {
        super(size);
        queue = new int[size];
        count = 0;
    }

    @Override
    void add(int element) {
        int i = count;
        while (element < queue[i - 1]) {
            queue[i] = queue[i - 1];
        }
        queue[i] = element;
        count++;
    }

	@Override
    int delete() {
        int element = queue[0];
        int i = 0;
        while (i < count) {
            queue[i + 1] = queue[i];
            i++;
        }
        count--;
        return element;
    }

    @Override
    int peek() {
        return queue[0];
    }
}