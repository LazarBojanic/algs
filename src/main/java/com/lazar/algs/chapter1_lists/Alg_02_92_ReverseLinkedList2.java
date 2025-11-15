package com.lazar.algs.chapter1_lists;

import com.lazar.algs.common.Util;
import com.lazar.algs.common.linked_list.AlgListNode;

public class Alg_02_92_ReverseLinkedList2 {
	public <T> AlgListNode<T> reverseBetween(AlgListNode<T> head, int left, int right) {
		if (head == null) {
			return null;
		}
		AlgListNode<T> dummy = new AlgListNode<>();
		dummy.next = head;
		AlgListNode<T> prev = dummy;
		for (int i = 0; i < left - 1; i++) {
			prev = prev.next;
		}
		AlgListNode<T> start = prev.next;
		AlgListNode<T> then = start.next;
		for (int i = 0; i < right - left; i++) {
			start.next = then.next;
			then.next = prev.next;
			prev.next = then;
			then = start.next;
		}
		return dummy.next;
	}

	public void run() {
		AlgListNode<Integer> list = Util.createLinkedList(1, 2, 3, 4, 5);
		AlgListNode<Integer> reverseBetweenList = reverseBetween(list, 2, 4);
		Util.printList(reverseBetweenList);
	}
}
