package com.company.queue;

import com.company.exceptions.EmptyQueueException;
import com.company.exceptions.FullQueueException;

public abstract class AbstractQueue {

    int maxSize;
    int[] queue;
    int front;
    int rear;
    int count;

    public AbstractQueue(int size) {
        maxSize = size;
        front = 0;
        rear = -1;
    }

    void insert(int element) throws FullQueueException {
        if (!isFull()) {
            add(element);
        } else {
            throw new FullQueueException("Queue is full.");
        }
    }

    int remove() throws EmptyQueueException {
        if (!isEmpty()) {
            return delete();
        } else {
            throw new EmptyQueueException("Queue is empty.");
        }
    }

    int peek() {
        return queue[front];
    }

    /**
     * 4.1. Напишите метод класса Queue программы queue.java для вывода содержимого очереди.
     * Учтите, что задача не сводится к простому выводу содержимого базового массива.
     * Содержимое очереди должно выводиться от первого вставленного элемента до последнего,
     *  а пользователь не должен видеть, что последовательность прерывается на границе
     *  массива. Будьте внимательны и проследите за тем, чтобы один элемент и содержимое
     *  пустой очереди выводились корректно независимо от положения front и rear.
     */
    void display() { // correctly works on both queues
        int times = size();
        for (int i = front; times > 0; times--) {
            System.out.print(queue[i] + "\t");
            i = (i < maxSize - 1) ? i + 1 : 0;
        }
        System.out.println(System.lineSeparator());
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

    void add(int element) {
        rear = (rear < maxSize - 1) ? rear : -1;
        queue[++rear] = element;
    }

    int delete() {
        int result = queue[front];
        queue[front++] = 0;
        front = (front < maxSize) ? front : 0;
        return result;
    }
}
