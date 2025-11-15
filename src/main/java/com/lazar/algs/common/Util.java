package com.lazar.algs.common;

import com.lazar.algs.common.binary_tree.AlgTreeNode;
import com.lazar.algs.common.linked_list.AlgListNode;
import com.lazar.algs.common.queue.AlgLinkedListQueue;

import java.util.ArrayList;
import java.util.List;

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
	public static AlgTreeNode createTree(Integer[] arr) {
		if (arr == null || arr.length == 0 || arr[0] == null) {
			return null;
		}
		AlgTreeNode root = new AlgTreeNode(arr[0]);
		AlgLinkedListQueue<AlgTreeNode> queue = new AlgLinkedListQueue<>();
		queue.pushBack(root);
		int i = 1;
		while (i < arr.length) {
			AlgTreeNode current = queue.popFront();
			if (arr[i] != null) {
				current.left = new AlgTreeNode(arr[i])  ;
				queue.pushBack(current.left);
			}
			i++;
			if (i < arr.length && arr[i] != null) {
				current.right = new AlgTreeNode(arr[i]);
				queue.pushBack(current.right);
			}
			i++;
		}
		return root;
	}
	public static List<Integer> toLevelOrderList(AlgTreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) {
			return result;
		}

		AlgLinkedListQueue<AlgTreeNode> queue = new AlgLinkedListQueue<>();
		queue.pushBack(root);

		while (!queue.isEmpty()) {
			AlgTreeNode node = queue.popFront();
			if (node != null) {
				result.add(node.val);
				queue.pushBack(node.left);
				queue.pushBack(node.right);
			} else {
				result.add(null);
			}
		}

		int lastNonNull = result.size() - 1;
		while (lastNonNull >= 0 && result.get(lastNonNull) == null) {
			lastNonNull--;
		}
		return result.subList(0, lastNonNull + 1);
	}

	public static void printTree(AlgTreeNode root) {
		System.out.println(toLevelOrderList(root));
	}
}
