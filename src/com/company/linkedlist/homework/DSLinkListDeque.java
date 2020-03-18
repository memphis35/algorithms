package com.company.linkedlist.homework;

import com.company.linkedlist.doublesidedlinklist.DoubleSidedLinkList;
import com.company.linkedlist.linklist.Link;

/**
 * @homework 5.2. Реализуйте дек на базе двусвязного списка. Дек должен поддерживать все стандартные операции.
 */

public class DSLinkListDeque {

    DoubleSidedLinkList deque = new DoubleSidedLinkList();

    public void PushFront(String data) {
        deque.insert(data);
    }

    public void PushBack(String data) {
        deque.insertLast(data);
    }

    public Link PopFront() {
        return deque.delete();
    }

    public Link PopBack() {
        return deque.deleteLast();
    }

    public Link peekFront() {
        return deque.getFirst();
    }

    public Link peekBack() {
        return deque.getLast();
    }

    public void clear() {
        deque.clear();
    }
}
