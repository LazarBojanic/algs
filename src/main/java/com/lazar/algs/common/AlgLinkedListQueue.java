package com.lazar.algs.common;

public class AlgLinkedListQueue<T> {
	private AlgQueueNode<T> head;
	private AlgQueueNode<T> tail;
	private int size;


	public AlgLinkedListQueue() {
		head = tail = null;
		size = 0;
	}


	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}


	public void pushLast(T value) {
		AlgQueueNode<T> node = new AlgQueueNode<>(value);
		if (isEmpty()) {
			head = tail = node;
		}
		else {
			tail.next = node;
			tail = node;
		}
		size++;
	}


	public T popFirst() {
		if (isEmpty()) {
			throw new RuntimeException("Queue underflow");
		}
		T val = head.val;
		head = head.next;
		if (head == null) {
			tail = null;
		}
		size--;
		return val;
	}


	public T peekFirst() {
		if (isEmpty()) {
			throw new RuntimeException("Queue is empty");
		}
		return head.val;
	}
}