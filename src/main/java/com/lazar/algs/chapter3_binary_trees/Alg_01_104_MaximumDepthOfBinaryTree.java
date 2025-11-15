package com.lazar.algs.chapter3_binary_trees;

import com.lazar.algs.common.binary_tree.AlgTreeNode;

public class Alg_01_104_MaximumDepthOfBinaryTree {
	public int maxDepth(AlgTreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftDepth = maxDepth(root.left);
		int rightDepth = maxDepth(root.right);

		return Math.max(leftDepth, rightDepth) + 1;
	}
}
