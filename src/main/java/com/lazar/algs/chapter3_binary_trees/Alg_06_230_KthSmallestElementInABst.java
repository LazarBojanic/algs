package com.lazar.algs.chapter3_binary_trees;

import com.lazar.algs.common.Util;
import com.lazar.algs.common.binary_tree.AlgTreeNode;

public class Alg_06_230_KthSmallestElementInABst {
	private int count = 0;
	private int result = 0;

	public int kthSmallest(AlgTreeNode root, int k) {
		count = k;
		inOrder(root);
		return result;
	}

	private void inOrder(AlgTreeNode node) {
		if (node == null) {
			return;
		}
		inOrder(node.left);
		count--;
		if (count == 0) {
			result = node.val;
			return;
		}
		inOrder(node.right);
	}
	public void run(){
		int k = 3;
		Integer[] arr = new Integer[] { 5, 3, 6, 2, 4, null, null, 1 };
		System.out.println(kthSmallest(Util.createTree(arr), k));
	}
}
