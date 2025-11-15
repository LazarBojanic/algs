package com.lazar.algs.common;

import com.lazar.algs.common.linked_list.AlgListNode;

public class Util {
	public static Integer MAX_CAPACITY = 100000;
	public static <T> void printList(AlgListNode<T> head) {
		while (head != null) {
			System.out.print(head.val + "->");
			head = head.next;
		}
		System.out.println("null");
	}

	@SafeVarargs
	public static <T> AlgListNode<T> createLinkedList(T... values) {
		if (values == null || values.length == 0) {
			return null;
		}
		AlgListNode<T> head = new AlgListNode<T>(values[0]);
		AlgListNode<T> current = head;
		for (int i = 1; i < values.length; i++) {
			current.next = new AlgListNode<T>(values[i]);
			current = current.next;
		}
		return head;
	}
}
