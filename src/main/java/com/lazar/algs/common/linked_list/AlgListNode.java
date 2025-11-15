package com.lazar.algs.common.linked_list;

public class AlgListNode<T> {
	public T val;
	public AlgListNode<T> next;

	public AlgListNode() {
		this.val = null;
		this.next = null;
	}

	public AlgListNode(T val) {
		this.val = val;
		this.next = null;
	}

	public AlgListNode(T val, AlgListNode<T> next) {
		this.val = val;
		this.next = next;
	}
}
