package com.company.linkedlist.linklist;

public interface LinkListInterface {

    void insert(String data);
    Link delete();
    void display();
    Link find(String key);
    Link getFirst();
    void clear();
}
