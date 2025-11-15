package com.lazar.algs.chapter1_lists;

import com.lazar.algs.common.Util;
import com.lazar.algs.common.linked_list.AlgListNode;

public class Alg_01_206_ReverseLinkedList {
	public <T> AlgListNode<T> reverseList(AlgListNode<T> head) {
		AlgListNode<T> curr = head;
		AlgListNode<T> prev = null;
		AlgListNode<T> next = null;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

	public void run() {
		AlgListNode<Integer> list = Util.createLinkedList(1, 2, 3, 4, 5);
		AlgListNode<Integer> reversedList = reverseList(list);
		Util.printList(reversedList);
	}
}
