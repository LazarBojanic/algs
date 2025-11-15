package com.lazar.algs.common.queue;

public class AlgQueueNode<T> {
	public T val;
	public AlgQueueNode<T> next;

	public AlgQueueNode() {
	}

	public AlgQueueNode(T val) {
		this.val = val;
	}

	public AlgQueueNode(T val, AlgQueueNode<T> next) {
		this.val = val;
		this.next = next;
	}
}