package com.lazar.algs.tests.test_2022_b;

import com.lazar.algs.common.Util;
import com.lazar.algs.common.binary_tree.AlgTreeNode;

/*
Time Complexity: O(N) - visit each node once
Space Complexity: O(H) - recursion stack, H = height of tree
*/
public class Test_2022_B_Task_2A {
	private int count = 0;

	public int countBeautiful(AlgTreeNode root) {
		helper(root);
		return count;
	}

	private boolean helper(AlgTreeNode node) {
		if (node == null) {
			return false;
		}
		if (node.left == null && node.right == null) {
			count++;
			return true;
		}
		boolean leftBeautiful = helper(node.left);
		boolean rightBeautiful = helper(node.right);
		if ((leftBeautiful ^ rightBeautiful)) {
			count++;
			return true;
		}
		return false;
	}

	public void run() {
		Integer[] arr = {1, 1, 1, 1, 1, null, null, 1, 1, null, 1};
		AlgTreeNode root = Util.createTree(arr);
		System.out.println(countBeautiful(root));
	}
}
