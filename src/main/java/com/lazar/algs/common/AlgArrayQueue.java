package com.lazar.algs.common;

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
		this.capacity = Integer.MAX_VALUE;
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

	public void pushLast(T value) {
		if (isFull()) {
			throw new RuntimeException("Queue overflow");
		}
		rear = (rear + 1) % capacity;
		arr[rear] = value;
		size++;
	}

	public T popFirst() {
		if (isEmpty()) {
			throw new RuntimeException("Queue underflow");
		}
		T val = arr[front];
		front = (front + 1) % capacity;
		size--;
		return val;
	}

	public T peekFirst() {
		if (isEmpty()) {
			throw new RuntimeException("Queue is empty");
		}
		return arr[front];
	}

	public T[] getArr() {
		return arr;
	}

	public int getCapacity() {
		return capacity;
	}
}
