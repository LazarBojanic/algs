package com.lazar.algs.common;

public class AlgLinkedListFullQueue<T> {

	private AlgLinkedListDequeue<T> left;
	private AlgLinkedListDequeue<T> right;

	public AlgLinkedListFullQueue() {
		left = new AlgLinkedListDequeue<>();
		right = new AlgLinkedListDequeue<>();
	}

	private void rebalance() {
		if (left.size() > right.size() + 1) {
			right.pushFirst(left.popLast());
		}
		else if (left.size() < right.size()) {
			left.pushLast(right.popFirst());
		}
	}

	public void pushFront(T val) {
		left.pushFirst(val);
		rebalance();
	}

	public void pushMiddle(T val) {
		if (left.size() > right.size()) {
			right.pushFirst(left.popLast());
		}
		left.pushLast(val);
		rebalance();
	}

	public void pushBack(T val) {
		right.pushLast(val);
		rebalance();
	}

	public T popFront() {
		if (isEmpty()) {
			return null;
		}
		else {
			T val = left.popFirst();
			rebalance();
			return val;
		}
	}

	public T popMiddle() {
		if (isEmpty()) {
			return null;
		}
		else {
			T val = left.popLast();
			rebalance();
			return val;
		}
	}

	public T popBack() {
		if (isEmpty()) {
			return null;
		}
		else {
			T val;
			if (!right.isEmpty()) {
				val = right.popLast();
			}
			else {
				val = left.popLast();
			}
			rebalance();
			return val;
		}
	}

	public int size() {
		return left.size() + right.size();
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public T peekFront() {
		if (isEmpty()) {
			return null;
		}
		else {
			return left.peekFirst();
		}
	}

	public T peekMiddle() {
		if (isEmpty()) {
			return null;
		}
		else {
			return left.peekLast();
		}
	}

	public T peekBack() {
		if (isEmpty()) {
			return null;
		}
		else {
			if (!right.isEmpty()) {
				return right.peekLast();
			}
			else {
				return left.peekLast();
			}
		}
	}
}