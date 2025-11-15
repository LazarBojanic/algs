package com.lazar.algs.common;

public class AlgLinkedListDequeue<T> {
	private AlgQueueNode<T> head;
	private AlgQueueNode<T> tail;
	private int size;

	public AlgLinkedListDequeue() {
		head = tail = null;
		size = 0;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public void pushFirst(T value) {
		AlgQueueNode<T> node = new AlgQueueNode<>(value);
		if (isEmpty()) {
			head = tail = node;
		}
		else {
			node.next = head;
			head.prev = node;
			head = node;
		}
		size++;
	}


	public void pushLast(T value) {
		AlgQueueNode<T> node = new AlgQueueNode<>(value);
		if (isEmpty()) {
			head = tail = node;
		}
		else {
			tail.next = node;
			node.prev = tail;
			tail = node;
		}
		size++;
	}


	public T popFirst() {
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


	public T popLast() {
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


	public T peekFirst() {
		if (isEmpty()) {
			throw new RuntimeException("Deque is empty");
		}
		return head.val;
	}

	public T peekLast() {
		if (isEmpty()) {
			throw new RuntimeException("Deque is empty");
		}
		return tail.val;
	}
}
