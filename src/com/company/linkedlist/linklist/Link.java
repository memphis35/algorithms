package com.company.linkedlist.linklist;

public class Link {

    public Link next;
    private String data;

    public Link(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public Link getNext() {
        return next;
    }

    public void displayLink() {
        System.out.println(data);
    }

    @Override
    public boolean equals(Object obj) {
        if (this.getClass().equals(obj.getClass())) {
            return this.data.equals(((Link) obj).getData());
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return data.hashCode();
    }


}
