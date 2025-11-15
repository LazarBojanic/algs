package com.lazar.algs.common;

public class AlgArrayMaxStack<T extends Number> {

	private AlgArrayStack<T> stack;
	private AlgArrayStack<T> maxStack;

	public AlgArrayMaxStack(int capacity) {
		stack = new AlgArrayStack<>(capacity);
		maxStack = new AlgArrayStack<>(capacity);
	}

	public AlgArrayMaxStack() {
		stack = new AlgArrayStack<>();
		maxStack = new AlgArrayStack<>();
	}

	public void push(T value) {
		stack.push(value);
		if (maxStack.isEmpty()) {
			maxStack.push(value);
		}
		else {
			Number currentMax = maxStack.peek();
			if (value.doubleValue() >= currentMax.doubleValue()) {
				maxStack.push(value);
			}
		}
	}

	public T pop() {
		if (stack.isEmpty()) {
			throw new RuntimeException("Stack underflow");
		}
		T val = stack.pop();
		if (!maxStack.isEmpty() && val.doubleValue() == maxStack.peek().doubleValue()) {
			maxStack.pop();
		}
		return val;
	}

	public T peek() {
		return stack.peek();
	}

	public T getMax() {
		if (maxStack.isEmpty()) {
			throw new RuntimeException("Stack is empty");
		}
		return maxStack.peek();
	}

	public boolean isEmpty() {
		return stack.isEmpty();
	}

	public int size() {
		return stack.size();
	}
}