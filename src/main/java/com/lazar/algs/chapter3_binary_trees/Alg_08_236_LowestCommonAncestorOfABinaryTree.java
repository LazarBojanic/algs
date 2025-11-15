package com.lazar.algs.chapter3_binary_trees;

import com.lazar.algs.common.binary_tree.AlgTreeNode;

public class Alg_08_236_LowestCommonAncestorOfABinaryTree {
	public AlgTreeNode lowestCommonAncestor(AlgTreeNode root, AlgTreeNode p, AlgTreeNode q) {
		if (root == null) {
			return null;
		}
		if (root == p || root == q) {
			return root;
		}

		AlgTreeNode left = lowestCommonAncestor(root.left, p, q);
		AlgTreeNode right = lowestCommonAncestor(root.right, p, q);

		if (left != null && right != null) {
			return root;
		}
		if (left != null) {
			return left;
		}
		else{
			return right;
		}
	}
}
