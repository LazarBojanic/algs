package com.lazar.algs.chapter3_binary_trees;

import com.lazar.algs.common.binary_tree.AlgTreeNode;

public class Alg_05_98_ValidateBinarySearchTree {
	public boolean isValidBST(AlgTreeNode root) {
		return validate(root, null, null);
	}

	private boolean validate(AlgTreeNode node, Integer min, Integer max) {
		if (node == null) {
			return true;
		}

		if ((min != null && node.val <= min) || (max != null && node.val >= max)) {
			return false;
		}

		return validate(node.left, min, node.val) && validate(node.right, node.val, max);
	}
}
