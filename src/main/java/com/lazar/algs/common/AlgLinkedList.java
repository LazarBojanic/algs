package com.lazar.algs.common;

public class AlgLinkedList<T> {
	private AlgListNode<T> head;
	private int size;

	public void add(T data) {
		AlgListNode<T> newNode = new AlgListNode<>(data);
		if (head == null) {
			head = newNode;
		}
		else {
			AlgListNode<T> current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = newNode;
		}
		size++;
	}

	public void add(int index, T data) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index out of range");
		}

		AlgListNode<T> newNode = new AlgListNode<>(data);

		if (index == 0) {
			newNode.next = head;
			head = newNode;
		}
		else {
			AlgListNode<T> current = head;
			for (int i = 0; i < index - 1; i++) {
				current = current.next;
			}
			newNode.next = current.next;
			current.next = newNode;
		}
		size++;
	}

	public T remove(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index out of range");
		}
		T removedData;
		if (index == 0) {
			removedData = head.val;
			head = head.next;
		}
		else {
			AlgListNode<T> current = head;
			for (int i = 0; i < index - 1; i++) {
				current = current.next;
			}
			removedData = current.next.val;
			current.next = current.next.next;
		}
		size--;
		return removedData;
	}

	public T get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index out of range");
		}

		AlgListNode<T> current = head;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		return current.val;
	}

	public int getSize() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void printList() {
		AlgListNode<T> current = head;
		while (current != null) {
			System.out.print(current.val + " -> ");
			current = current.next;
		}
		System.out.println("null");
	}
}
