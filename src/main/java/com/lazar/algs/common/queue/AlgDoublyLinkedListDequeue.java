package com.lazar.algs.common.queue;

public class AlgDoublyLinkedListDequeue<T> {
	private AlgDequeueNode<T> head;
	private AlgDequeueNode<T> tail;
	private int size;

	public AlgDoublyLinkedListDequeue() {
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

	public void pushFront(T value) {
		AlgDequeueNode<T> node = new AlgDequeueNode<>(value, head, null);
		if (isEmpty()) {
			tail = node;
		}
		else {
			head.prev = node;
		}
		head = node;
		size++;
	}

	public void pushBack(T value) {
		AlgDequeueNode<T> node = new AlgDequeueNode<>(value, null, tail);
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
			throw new RuntimeException("Deque underflow");
		}
		T val = head.val;
		head = head.next;
		if (head != null) {
			head.prev = null;
		}
		else {
			tail = null;
		}
		size--;
		return val;
	}

	public T popBack() {
		if (isEmpty()) {
			throw new RuntimeException("Deque underflow");
		}
		T val = tail.val;
		tail = tail.prev;
		if (tail != null) {
			tail.next = null;
		}
		else {
			head = null;
		}
		size--;
		return val;
	}

	public T peekFront() {
		if (isEmpty()) throw new RuntimeException("Deque is empty");
		return head.val;
	}

	public T peekBack() {
		if (isEmpty()) throw new RuntimeException("Deque is empty");
		return tail.val;
	}
}
