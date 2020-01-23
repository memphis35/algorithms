package com.company.stack;

import com.company.exceptions.EmptyStackException;
import com.company.exceptions.FullStackException;

import java.util.Arrays;

public class ArrayStack {

    private int[] stack;
    private int position;

    public ArrayStack(int size) {
        stack = new int[size];
        position = -1;
    }

    void push(int number) throws FullStackException {
        if (position == stack.length - 1) {
            throw new FullStackException("Error. Stack is full.");
        } else {
			position++;
            stack[position] = number;
        }
    }

    int pop() throws EmptyStackException {
		if (position < 0) {
			throw new EmptyStackException("Error. Stack is empty.");
		} else {
			return stack[position--];
		}
	}

    void peek() {
        System.out.println("Верхний элемент стека равняется " + stack[position]);
    }

    void display() {
        System.out.println(Arrays.toString(stack));
    }

    void clear() {
    	Arrays.fill(stack, 0);
	}

    int[] getStack() {
    	return stack;
	}

	public int getPosition() {
		return position;
	}
}
