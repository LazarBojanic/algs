package com.lazar.algs.chapter1_lists;

import com.lazar.algs.common.AlgListNode;
import com.lazar.algs.common.Util;

public class Alg_03_61_RotateRight {
	public <T> AlgListNode<T> rotateRight(AlgListNode<T> head, int k) {
		if (head == null) {
			return null;
		}
		if (head.next == null) {
			return head;
		}
		AlgListNode<T> oldTail = head;
		int n;
		for (n = 1; oldTail.next != null; n++) {
			oldTail = oldTail.next;
		}
		oldTail.next = head;
		AlgListNode<T> newTail = head;
		for (int i = 0; i < n - k % n - 1; i++) {
			newTail = newTail.next;
		}
		AlgListNode<T> newHead = newTail.next;
		newTail.next = null;
		return newHead;
	}

	public void run() {
		AlgListNode<Integer> list = Util.createLinkedList(1, 2, 3, 4, 5);
		AlgListNode<Integer> rotatedList = rotateRight(list, 2);
		Util.printList(rotatedList);
	}
}
