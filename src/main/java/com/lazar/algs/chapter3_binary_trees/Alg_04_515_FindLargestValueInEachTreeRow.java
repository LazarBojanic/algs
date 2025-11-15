package com.lazar.algs.chapter3_binary_trees;

import com.lazar.algs.common.binary_tree.AlgTreeNode;
import com.lazar.algs.common.queue.AlgDoublyLinkedListDequeue;
import com.lazar.algs.common.queue.AlgLinkedListQueue;

import java.util.ArrayList;
import java.util.List;

public class Alg_04_515_FindLargestValueInEachTreeRow {
	public List<Integer> largestValues(AlgTreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) {
			return result;
		}

		AlgLinkedListQueue<AlgTreeNode> queue = new AlgLinkedListQueue<>();

		queue.pushBack(root);

		while (!queue.isEmpty()) {
			int size = queue.size();
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < size; i++) {
				AlgTreeNode node = queue.popFront();
				max = Math.max(max, node.val);
				if (node.left != null){
					queue.pushBack(node.left);
				}
				if (node.right != null) {
					queue.pushBack(node.right);
				}
			}
			result.add(max);
		}
		return result;
	}
}
