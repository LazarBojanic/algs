package com.lazar.algs.tests.test_2022_a;

import com.lazar.algs.common.Util;
import com.lazar.algs.common.binary_tree.AlgTreeNode;

/*
Time Complexity: O(N) - each node visited once
Space Complexity: O(H) - recursion stack, H = height of tree
*/
public class Test_2022_A_Task_2A {
	private int count = 0;

	public int countNodes(AlgTreeNode root) {
		helper(root);
		return count;
	}

	private int helper(AlgTreeNode node) {
		if (node == null) {
			return 0;
		}
		if (node.left == null && node.right == null) {
			return node.val;
		}
		int sumLeaves = helper(node.left) + helper(node.right);
		if (sumLeaves % 2 == 0) {
			count++;
		}
		return sumLeaves;
	}

	public void run() {
		Integer[] arr = {4, 3, 2, 1, 5, 8, 3, null, null, 2, 3, 2, 5};
		AlgTreeNode root = Util.createTree(arr);
		System.out.println(countNodes(root));
	}
}
