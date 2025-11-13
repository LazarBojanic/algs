package com.lazar.algs.common;

public class AlgArrayStack<T> {
	private T[] stack;
	private int top;
	private int capacity;

	@SuppressWarnings("unchecked")
	public AlgArrayStack(int size) {
		capacity = size;
		stack = (T[]) new Object[capacity];
		top = -1;
	}

	public void push(T value) {
		if (isFull()) {
			throw new RuntimeException("Stack overflow");
		}
		stack[++top] = value;
	}

	public T pop() {
		if (isEmpty()) {
			throw new RuntimeException("Stack underflow");
		}
		return stack[top--];
	}

	public T peek() {
		if (isEmpty()) {
			throw new RuntimeException("Stack is empty");
		}
		return stack[top];
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public boolean isFull() {
		return top == capacity - 1;
	}

	public int size() {
		return top + 1;
	}
}
