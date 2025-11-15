package com.lazar.algs.chapter3_binary_trees;

import com.lazar.algs.common.Util;
import com.lazar.algs.common.binary_tree.AlgTreeNode;

public class Alg_03_129_SumRootToLeafNumbers {
	public int sumNumbers(AlgTreeNode root) {
		return helper(root, 0);
	}

	private int helper(AlgTreeNode node, int currentSum) {
		if (node == null) {
			return 0;
		}
		currentSum = currentSum * 10 + node.val;
		if (node.left == null && node.right == null) {
			return currentSum;
		}
		return helper(node.left, currentSum) + helper(node.right, currentSum);
	}
	public void run(){
		Integer[] arr = new Integer[] {4, 9, 0, 5, 1};
		System.out.println(sumNumbers(Util.createTree(arr)));
	}
}
