package com.company.linkedlist.doubleconnectedlinklist;

public class DoubleLink {

    public String data;
    DoubleLink previous;
    DoubleLink next;

    DoubleLink(String data) {
        this.data = data;
        next = null;
        previous = null;
    }

    public String getData() {
        return data;
    }
}
