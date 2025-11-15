package com.lazar.algs.chapter1_lists;

import com.lazar.algs.common.Util;
import com.lazar.algs.common.linked_list.AlgListNode;

public class Alg_04_83_RemoveDuplicatesFromSortedList {
	public <T> AlgListNode<T> deleteDuplicates(AlgListNode<T> head) {
		AlgListNode<T> current = head;
		while (current != null && current.next != null) {
			if (current.next.val == current.val) {
				current.next = current.next.next;
			}
			else {
				current = current.next;
			}
		}
		return head;
	}

	public void run() {
		AlgListNode<Integer> list = Util.createLinkedList(1, 2, 2, 3, 3, 3, 4, 4, 4, 5);
		AlgListNode<Integer> list2 = deleteDuplicates(list);
		Util.printList(list2);
	}
}