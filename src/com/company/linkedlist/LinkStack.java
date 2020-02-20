package com.company.linkedlist;

import com.company.exceptions.EmptyStackException;

public class LinkStack {

    private LinkList stack;

    public LinkStack() {
        stack = new LinkList();
    }

    public void push(String data) {
        stack.insertFirst(data);
    }

    public void pop() {
        stack.deleteFirst();
    }

    public Link peek() throws EmptyStackException {
        if (!isEmpty()) {
            return stack.first;
        } else {
            throw new EmptyStackException("Empty stack.");
        }
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
