package com.lazar.algs.chapter1_lists;

import com.lazar.algs.common.linked_list.AlgListNode;
import com.lazar.algs.common.Util;

public class Alg_09_86_PartitionList {
	public <T> AlgListNode<T> partition(AlgListNode<T> head, int x) {
		AlgListNode<T> beforeHead = new AlgListNode<T>();
		AlgListNode<T> before = beforeHead;
		AlgListNode<T> afterHead = new AlgListNode<T>();
		AlgListNode<T> after = afterHead;
		while (head != null) {
			if ((Integer) head.val < x) {
				before.next = head;
				before = before.next;
			}
			else {
				after.next = head;
				after = after.next;
			}
			head = head.next;
		}
		before.next = afterHead.next;
		after.next = null;
		return beforeHead.next;
	}

	public void run() {
		AlgListNode<Integer> list = Util.createLinkedList(1, 4, 3, 2, 5, 2);
		AlgListNode<Integer> list2 = partition(list, 3);
		Util.printList(list2);
	}
}
