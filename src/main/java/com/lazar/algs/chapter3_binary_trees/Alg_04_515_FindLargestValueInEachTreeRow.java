package com.lazar.algs.chapter3_binary_trees;

import com.lazar.algs.common.Util;
import com.lazar.algs.common.binary_tree.AlgTreeNode;
import com.lazar.algs.common.queue.AlgLinkedListQueue;

import java.util.ArrayList;
import java.util.List;

public class Alg_04_515_FindLargestValueInEachTreeRow {
	private List<Integer> result = new ArrayList<>();
	public List<Integer> largestValues(AlgTreeNode root) {
		dfs(root, 0);
		return result;
	}
	public void dfs(AlgTreeNode node, int depth) {
		if (node == null) {
			return;
		}
		if (result.size() == depth) {
			result.add(node.val);
		}
		else {
			result.set(depth, Math.max(result.get(depth), node.val));
		}
		dfs(node.left, depth + 1);
		dfs(node.right, depth + 1);
	}
	public void run() {
		Integer[] arr = new Integer[]{1, 3, 2, 5, 3, null, 9};
		System.out.println(largestValues(Util.createTree(arr)));
	}
}
