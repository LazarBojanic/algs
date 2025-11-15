package com.lazar.algs.chapter1_lists;

import com.lazar.algs.common.AlgListNode;
import com.lazar.algs.common.Util;

public class Alg_05_82_RemoveDuplicatesFromSortedList2 {
	public <T> AlgListNode<T> deleteDuplicates(AlgListNode<T> head) {
		AlgListNode<T> sentinel = new AlgListNode<T>(null, head);
		AlgListNode<T> pred = sentinel;
		while (head != null) {
			if (head.next != null && head.val == head.next.val) {
				while (head.next != null && head.val == head.next.val) {
					head = head.next;
				}
				pred.next = head.next;
			}
			else {
				pred = pred.next;
			}
			head = head.next;
		}
		return sentinel.next;
	}

	public void run() {
		AlgListNode<Integer> list = Util.createLinkedList(1, 2, 2, 3, 3, 3, 4, 4, 4, 5);
		AlgListNode<Integer> list2 = deleteDuplicates(list);
		Util.printList(list2);
	}
}