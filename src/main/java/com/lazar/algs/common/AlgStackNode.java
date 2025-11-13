package com.lazar.algs.common;

public class AlgStackNode<T> {
	public T val;
	public AlgStackNode<T> next;

	public AlgStackNode() {
		this.val = null;
		this.next = null;
	}
	public AlgStackNode(T val) {
		this.val = val;
		this.next = null;
	}
	public AlgStackNode(T val, AlgStackNode<T> next) {
		this.val = val;
		this.next = next;
	}

}
