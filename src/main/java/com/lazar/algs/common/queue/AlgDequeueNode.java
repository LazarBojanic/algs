package com.lazar.algs.common.queue;

public class AlgDequeueNode<T> {
	public T val;
	public AlgDequeueNode<T> next;
	public AlgDequeueNode<T> prev;

	public AlgDequeueNode() {
	}

	public AlgDequeueNode(T val) {
		this.val = val;
	}

	public AlgDequeueNode(T val, AlgDequeueNode<T> next, AlgDequeueNode<T> prev) {
		this.val = val;
		this.next = next;
		this.prev = prev;
	}
}