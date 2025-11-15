package com.lazar.algs.common.queue;


import static com.lazar.algs.common.Util.MAX_CAPACITY;

public class AlgArrayFullDequeue<T> {

	private AlgArrayDequeue<T> left;
	private AlgArrayDequeue<T> right;

	public AlgArrayFullDequeue(int capacity) {
		int half = (capacity + 1) / 2;
		left = new AlgArrayDequeue<>(half);
		right = new AlgArrayDequeue<>(capacity - half);
	}

	public AlgArrayFullDequeue() {
		int capacity = MAX_CAPACITY;
		int half = (capacity + 1) / 2;
		left = new AlgArrayDequeue<>(half);
		right = new AlgArrayDequeue<>(capacity - half);
	}

	private void rebalance() {
		if (left.size() > right.size() + 1) {
			right.pushFront(left.popBack());
		}
		else if (left.size() < right.size()) {
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
		if (isEmpty()) {
			return null;
		}
		else {
			T val = left.popFront();
			rebalance();
			return val;
		}
	}

	public T popMiddle() {
		if (isEmpty()) {
			return null;
		}
		else {
			T val = left.popBack();
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
				val = right.popBack();
			}
			else {
				val = left.popBack();
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
			return left.peekFront();
		}
	}

	public T peekMiddle() {
		if (isEmpty()) {
			return null;
		}
		else {
			return left.peekBack();
		}
	}

	public T peekBack() {
		if (isEmpty()) {
			return null;
		}
		else {
			if (!right.isEmpty()) {
				return right.peekBack();
			}
			else {
				return left.peekBack();
			}
		}
	}

	public int getCapacity() {
		return left.getCapacity() + right.getCapacity();
	}
}