package com.company.queue;

public class PriorityQueue extends AbstractQueue {

    public PriorityQueue(int size) {
        super(size);
        maxSize = size;
        queue = new int[size];
        count = 0;
    }

    @Override
    void add(int element) {
        int i;
        for (i = count; i > 0; i--) {
            if (element <= queue[i - 1]) {
                queue[i] = queue[i - 1];
            } else {
                break;
            }
        }
        queue[i] = element;
        count++;
    }

    @Override
    int delete() {
        int element = queue[0];
        int i;
        for (i = 0; i < count - 1; i++) {
            queue[i] = queue[i + 1];
        }
        queue[i] = 0;
        count--;
        return element;
    }

    @Override
    int peek() {
        return queue[0];
    }

    @Override
    void display() {
        for (int i = 0; i < count; i++) {
            System.out.print(queue[i] + "\t");
        }
        System.out.println(System.lineSeparator());
    }
}