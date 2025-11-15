package com.lazar.algs.common.queue;

public class AlgDoublyLinkedListFullDequeue<T> {
	private AlgDoublyLinkedListDequeue<T> left;
	private AlgDoublyLinkedListDequeue<T> right;

	public AlgDoublyLinkedListFullDequeue() {
		left = new AlgDoublyLinkedListDequeue<>();
		right = new AlgDoublyLinkedListDequeue<>();
	}

	private void rebalance() {
		while (left.size() > right.size() + 1) {
			right.pushFront(left.popBack());
		}
		while (left.size() < right.size()) {
			left.pushBack(right.popFront());
		}
	}

	public void pushFront(T val) {
		left.pushFront(val);
		rebalance();
	}

	public void pushMiddle(T val) {
		if (left.size() > right.size()) {
			right.pushFront(left.popBack());
		}
		left.pushBack(val);
		rebalance();
	}

	public void pushBack(T val) {
		right.pushBack(val);
		rebalance();
	}

	public T popFront() {
		if (isEmpty()) return null;
		T val = left.popFront();
		rebalance();
		return val;
	}

	public T popMiddle() {
		if (isEmpty()) return null;
		T val = left.popBack();
		rebalance();
		return val;
	}

	public T popBack() {
		if (isEmpty()) return null;
		T val = !right.isEmpty() ? right.popBack() : left.popBack();
		rebalance();
		return val;
	}

	public boolean isEmpty() {
		return left.isEmpty() && right.isEmpty();
	}

	public int size() {
		return left.size() + right.size();
	}

	public T peekFront() {
		return isEmpty() ? null : left.peekFront();
	}

	public T peekMiddle() {
		return isEmpty() ? null : left.peekBack();
	}

	public T peekBack() {
		if (isEmpty()) return null;
		return !right.isEmpty() ? right.peekBack() : left.peekBack();
	}
}
