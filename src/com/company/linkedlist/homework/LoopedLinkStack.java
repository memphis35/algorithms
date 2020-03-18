package com.company.linkedlist.homework;

/**
 * @homework 5.4. Реализуйте класс стека на базе циклического списка из проекта 5.3. Этот
 * проект не слишком сложен. (Впрочем, реализовать очередь будет уже сложнее,
 * если только не перейти к двусвязному списку.)
 */

public class LoopedLinkStack {

    private LoopedLinkList stack = new LoopedLinkList();

    public void push(String data) {
        stack.insert(data);
    }

    public String pop() {
        return stack.delete().getData();
    }

    public String peek() {
        return stack.getCurrent().getNext().getData();
    }
}
