package com.company.stack;

public class StackApp {

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);
        stack.push(345);
        stack.getStack();
        stack.display();
    }
}
