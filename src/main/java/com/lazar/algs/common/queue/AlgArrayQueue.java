package com.lazar.algs.common.queue;

import static com.lazar.algs.common.Util.MAX_CAPACITY;

public class AlgArrayQueue<T> {
	private T[] arr;
	private int front;
	private int rear;
	private int size;
	private int capacity;

	@SuppressWarnings("unchecked")
	public AlgArrayQueue(int capacity) {
		this.capacity = capacity;
		arr = (T[]) new Object[capacity];
		front = 0;
		rear = -1;
		size = 0;
	}

	@SuppressWarnings("unchecked")
	public AlgArrayQueue() {
		this.capacity = MAX_CAPACITY;
		arr = (T[]) new Object[capacity];
		front = 0;
		rear = -1;
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

	public void pushBack(T value) {
		if (isFull()) {
			throw new RuntimeException("Queue overflow");
		}
		rear = (rear + 1) % capacity;
		arr[rear] = value;
		size++;
	}

	public T popFront() {
		if (isEmpty()) {
			throw new RuntimeException("Queue underflow");
		}
		T val = arr[front];
		front = (front + 1) % capacity;
		size--;
		return val;
	}

	public T peekFront() {
		if (isEmpty()) {
			throw new RuntimeException("Queue is empty");
		}
		return arr[front];
	}


	public int getCapacity() {
		return capacity;
	}
}
