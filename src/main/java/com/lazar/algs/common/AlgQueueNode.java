package com.lazar.algs.common;

public class AlgQueueNode<T> {
	public T val;
	public AlgQueueNode<T> next;
	public AlgQueueNode<T> prev;

	public AlgQueueNode() {
	}

	public AlgQueueNode(T val) {
		this.val = val;
	}

	public AlgQueueNode(T val, AlgQueueNode<T> next, AlgQueueNode<T> prev) {
		this.val = val;
		this.next = next;
		this.prev = prev;
	}
}