package com.lazar.algs.common.queue;

import static com.lazar.algs.common.Util.MAX_CAPACITY;

public class AlgArrayDequeue<T> {
	private T[] arr;
	private int front;
	private int back;
	private int size;
	private int capacity;

	@SuppressWarnings("unchecked")
	public AlgArrayDequeue(int capacity) {
		this.capacity = capacity;
		arr = (T[]) new Object[capacity];
		front = 0;
		back = -1;
		size = 0;
	}

	@SuppressWarnings("unchecked")
	public AlgArrayDequeue() {
		this.capacity = MAX_CAPACITY;
		arr = (T[]) new Object[capacity];
		front = 0;
		back = -1;
		size = 0;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean isFull() {
		return size == capacity;
	}

	public int size() {
		return size;
	}

	public void pushFront(T value) {
		if (isFull()) {
			throw new RuntimeException("Deque overflow");
		}
		front = (front - 1 + capacity) % capacity;
		arr[front] = value;
		size++;
		if (size == 1) {
			back = front;
		}
	}

	public void pushBack(T value) {
		if (isFull()) {
			throw new RuntimeException("Deque overflow");
		}
		back = (back + 1) % capacity;
		arr[back] = value;
		size++;
	}

	public T popFront() {
		if (isEmpty()) {
			throw new RuntimeException("Deque underflow");
		}
		T val = arr[front];
		front = (front + 1) % capacity;
		size--;
		return val;
	}

	public T popBack() {
		if (isEmpty()) {
			throw new RuntimeException("Deque underflow");
		}
		T val = arr[back];
		back = (back - 1 + capacity) % capacity;
		size--;
		return val;
	}

	public T peekFront() {
		if (isEmpty()) {
			throw new RuntimeException("Deque is empty");
		}
		return arr[front];
	}

	public T peekBack() {
		if (isEmpty()) {
			throw new RuntimeException("Deque is empty");
		}
		return arr[back];
	}

	public int getCapacity() {
		return capacity;
	}
}