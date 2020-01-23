package com.company.stack;

import java.util.Arrays;

public class Stack {

	int[] stack;
	int position;

	public Stack(int size) {
		stack = new int[size];
		position = -1;
	}
	
	void push(int number) {
		stack[++position] = number;
	}
	
	int pop() throws EmptyStackException {
		if (isEmpty) throw new EmptyStackException("Error. Stack is empty.")
		return stack[position--];
	}
	
	void peek() {
		System.out.println("Верхний элемент стека равняется " + stack[position]);
	}
  
  void display() {
    System.out.println(Arrays.toString(stack));
  }
	
}
