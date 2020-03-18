package com.company.queue;

import com.company.exceptions.EmptyQueueException;
import com.company.exceptions.FullQueueException;

/**
 * @homework 4.2. Создайте класс Deque по описанию деков (двусторонних очередей) в этой главе.
 * Класс должен содержать методы insertLeft(), insertRight(), removeLeft(),
 * removeRight(), isEmpty() и isFull(). Также в нем должна быть реализована поддержка
 * циклического переноса индексов, по аналогии с очередями.
 */

public class CustomDeque {

    private int maxSize;
    private int[] queue;
    private int front;
    private int rear;
    private int count;

    public CustomDeque(int size) {
        maxSize = size;
        queue = new int[size];
        front = 0;
        rear = -1;
        count = 0;
    }

    public int getRear() {
        return rear;
    }

    public int[] getQueue() {
        return queue;
    }

    void insertRight(int element) throws FullQueueException {
        if (!isFull()) {
            rear = (rear < maxSize - 1) ? rear : -1;
            queue[++rear] = element;
            count++;
        } else {
            throw new FullQueueException("Queue is full.");
        }
    }

    void insertLeft(int element) throws FullQueueException {
        if (!isFull()) {
            front = (front > 0) ? front : maxSize;
            queue[--front] = element;
            count++;
        } else {
            throw new FullQueueException("Queue is full.");
        }
    }

    int removeLeft() throws EmptyQueueException {
        if (!isEmpty()) {
            int result = queue[front];
            queue[front++] = 0;
            front = (front < maxSize) ? front : 0;
            count--;
            return result;
        } else {
            throw new EmptyQueueException("Queue is empty.");
        }
    }

    int removeRight() throws EmptyQueueException {
        if (!isEmpty()) {
            int result = queue[rear];
            queue[rear--] = 0;
            rear = (rear > 0) ? rear : maxSize - 1;
            count--;
            return result;
        } else {
            throw new EmptyQueueException("Queue is empty.");
        }
    }

    int size() {
        return count;
    }

    boolean isFull() {
        return count == maxSize;
    }

    boolean isEmpty() {
        return count == 0;
    }

    void display() {
        int times = size();
        for (int i = front; times > 0; times--) {
            System.out.print(queue[i] + "\t");
            i = (i < maxSize - 1) ? i + 1 : 0;
        }
        System.out.println(System.lineSeparator());
    }
}
