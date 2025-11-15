package com.lazar.algs.common.binary_tree;

public class AlgTreeNode {
	public int val;
	public AlgTreeNode left;
	public AlgTreeNode right;

	public AlgTreeNode() {
		this.val = 0;
		this.left = null;
		this.right = null;
	}

	public AlgTreeNode(int val) {
		this.val = val;
		this.left = null;
		this.right = null;
	}

	public AlgTreeNode(int val, AlgTreeNode left, AlgTreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}
