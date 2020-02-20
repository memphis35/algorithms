package com.company.queue;

import com.company.exceptions.EmptyStackException;

/**
 * 4.3. Напишите реализацию стека на базе класса Deque из п. 4.2. Класс стека должен
 * поддерживать те же методы и возможности, что и класс StackX в программе stack.java (см. листинг 4.1).
 */

public class DequeStack {

    private CustomDeque stack;

    public DequeStack(int size) {
        stack = new CustomDeque(size);
    }

    public void push(int element) {
        stack.insertRight(element);
    }

    public int pop() {
        return stack.removeRight();
    }

    public int peek() throws EmptyStackException {
        if (!stack.isEmpty()) {
            return stack.getQueue()[stack.getRear()];
        } else {
            throw new EmptyStackException("Empty stack.");
        }
    }
}
