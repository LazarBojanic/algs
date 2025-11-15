package com.lazar.algs.common;

public class AlgLinkedListStack<T> {

	private AlgStackNode<T> top;
	private int size;

	public AlgLinkedListStack() {
		this.top = null;
		this.size = 0;
	}

	public void push(T value) {
		AlgStackNode<T> newNode = new AlgStackNode<>(value);
		newNode.next = top;
		top = newNode;
		size++;
	}

	public T pop() {
		if (isEmpty()) {
			throw new RuntimeException("Stack underflow");
		}
		T value = top.val;
		top = top.next;
		size--;
		return value;
	}

	public int getSize() {
		return size;
	}

	public T peek() {
		if (isEmpty()) {
			throw new RuntimeException("Stack is empty");
		}
		return top.val;
	}

	public boolean isEmpty() {
		return top == null;
	}

}

