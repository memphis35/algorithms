package com.company.linkedlist.doubleconnectedlinklist;

import com.company.linkedlist.linklist.Link;

public class DoubleConnectedLinkList {

    private DoubleLink first;
    private DoubleLink last;

    private void insertFirst(DoubleLink element) {
        last = element;
        first = element;
    }

    public void insert(String data) {
        DoubleLink element = new DoubleLink(data);
        if (isEmpty()) {
            insertFirst(element);
        } else {
            element.next = first;
            first.previous = element;
            first = element;
        }
    }

    public void insertBack(String data) {
        DoubleLink element = new DoubleLink(data);
        if (isEmpty()) {
            insertFirst(element);
        } else {
            last.next = element;
            element.previous = last;
            last = element;
        }
    }

    public DoubleLink delete() {
        DoubleLink result = first;
        if (!first.equals(last)) {
            first = first.next;
            first.previous = null;
        } else {
            first = null;
            last = null;
        }
        return result;
    }

    public DoubleLink deleteBack() {
        DoubleLink result = last;
        if (!first.equals(last)) {
            last = last.previous.next;
            last.next = null;
        } else {
            delete();
        }
        return result;
    }

    public void display() {
        DoubleLink current = first;
        System.out.print("\n");
        while (current != null) {
            System.out.println(current.getData());
            current = current.next;
        }
    }

    public void clear() {
        while (!isEmpty()) {
            delete();
        }
    }

    private boolean isEmpty() {
        return first == null & last == null;
    }

    public static void main(String[] args) {
        DoubleConnectedLinkList example = new DoubleConnectedLinkList();
        example.insert("Mike");
        example.insert("Alex");
        example.insert("Fiona");
        example.insert("Shaun");
        example.display();
        while (!example.isEmpty()) {
            example.delete();
            example.display();
        }
    }
}
