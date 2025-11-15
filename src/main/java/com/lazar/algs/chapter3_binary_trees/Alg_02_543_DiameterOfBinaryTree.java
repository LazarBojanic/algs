package com.lazar.algs.chapter3_binary_trees;

import com.lazar.algs.common.binary_tree.AlgTreeNode;

public class Alg_02_543_DiameterOfBinaryTree {
	private int maxDiameter = 0;

	public int diameterOfBinaryTree(AlgTreeNode root) {
		depth(root);
		return maxDiameter;
	}

	private int depth(AlgTreeNode node) {
		if (node == null) {
			return 0;
		}

		int leftDepth = depth(node.left);
		int rightDepth = depth(node.right);

		if (leftDepth + rightDepth > maxDiameter) {
			maxDiameter = leftDepth + rightDepth;
		}

		return Math.max(leftDepth, rightDepth) + 1;
	}
}
