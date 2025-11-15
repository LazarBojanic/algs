package com.lazar.algs.chapter1_lists;

import com.lazar.algs.common.AlgListNode;
import com.lazar.algs.common.Util;

public class Alg_07_24_SwapNodesInPairs {
	public <T> AlgListNode<T> swapPairsRecursive(AlgListNode<T> head) {
		if (head == null || head.next == null) {
			return head;
		}
		AlgListNode<T> firstNode = head;
		AlgListNode<T> secondNode = head.next;
		firstNode.next = swapPairsRecursive(secondNode.next);
		secondNode.next = firstNode;
		return secondNode;
	}

	public <T> AlgListNode<T> swapPairsIterative(AlgListNode<T> head) {
		AlgListNode<T> dummy = new AlgListNode<T>();
		dummy.next = head;
		AlgListNode<T> current = dummy;
		while (current.next != null && current.next.next != null) {
			AlgListNode<T> first = current.next;
			AlgListNode<T> second = current.next.next;
			first.next = second.next;
			current.next = second;
			current.next.next = first;
			current = current.next.next;
		}
		return dummy.next;
	}

	public void run() {
		AlgListNode<Integer> list = Util.createLinkedList(1, 2, 3, 4, 5);
		AlgListNode<Integer> list2 = swapPairsIterative(list);
		Util.printList(list2);
	}
}
