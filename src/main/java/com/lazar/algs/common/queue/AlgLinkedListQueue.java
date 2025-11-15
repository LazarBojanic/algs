package com.lazar.algs.common.queue;

public class AlgLinkedListQueue<T> {
	private AlgQueueNode<T> head;
	private AlgQueueNode<T> tail;
	private int size;

	public AlgLinkedListQueue() {
		head = null;
		tail = null;
		size = 0;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}


	public void pushBack(T value) {
		AlgQueueNode<T> node = new AlgQueueNode<>(value);

		if (isEmpty()) {
			head = node;
		}
		else {
			tail.next = node;
		}
		tail = node;
		size++;
	}


	public T popFront() {
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


	public T peekFront() {
		if (isEmpty()) {
			throw new RuntimeException("Queue is empty");
		}
		return head.val;
	}
}