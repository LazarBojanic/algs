package com.lazar.algs.chapter3_binary_trees;

import com.lazar.algs.common.Util;
import com.lazar.algs.common.binary_tree.AlgTreeNode;

public class Alg_08_236_LowestCommonAncestorOfABinaryTree {
	public AlgTreeNode lowestCommonAncestor(AlgTreeNode root, AlgTreeNode p, AlgTreeNode q) {
		if (root == null) {
			return null;
		}
		if (root.val == p.val || root.val == q.val) {
			return root;
		}
		AlgTreeNode left = lowestCommonAncestor(root.left, p, q);
		AlgTreeNode right = lowestCommonAncestor(root.right, p, q);
		if (left != null && right != null) {
			return root;
		}
		if (left != null){
			return left;
		}
		else{
			return right;
		}
	}

	public void run() {
		Integer[] arr = {3, 5, 1, 6, 2, 0, 8, null, null, 7, 4};
		AlgTreeNode root = Util.createTree(arr);
		AlgTreeNode p = new AlgTreeNode(6);
		AlgTreeNode q = new AlgTreeNode(4);
		System.out.println(lowestCommonAncestor(root, p, q).val);
	}
}
