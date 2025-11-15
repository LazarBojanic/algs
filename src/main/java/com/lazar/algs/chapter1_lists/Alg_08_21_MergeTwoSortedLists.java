package com.lazar.algs.chapter1_lists;

import com.lazar.algs.common.AlgListNode;
import com.lazar.algs.common.Util;

public class Alg_08_21_MergeTwoSortedLists {
	public <T> AlgListNode<T> mergeTwoLists(AlgListNode<T> l1, AlgListNode<T> l2) {
		AlgListNode<T> prehead = new AlgListNode<T>();
		AlgListNode<T> prev = prehead;
		while (l1 != null && l2 != null) {
			if ((Integer) l1.val <= (Integer) l2.val) {
				prev.next = l1;
				l1 = l1.next;
			}
			else {
				prev.next = l2;
				l2 = l2.next;
			}
			prev = prev.next;
		}
		if (l1 == null) {
			prev.next = l2;
		}
		else {
			prev.next = l1;
		}
		return prehead.next;
	}

	public void run() {
		AlgListNode<Integer> list = Util.createLinkedList(1, 2, 4, 5);
		AlgListNode<Integer> list2 = Util.createLinkedList(1, 3, 4);
		AlgListNode<Integer> list3 = mergeTwoLists(list, list2);
		Util.printList(list3);
	}
}
