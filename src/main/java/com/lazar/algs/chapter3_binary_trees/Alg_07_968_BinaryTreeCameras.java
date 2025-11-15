package com.lazar.algs.chapter3_binary_trees;

import com.lazar.algs.common.Util;
import com.lazar.algs.common.binary_tree.AlgTreeNode;

public class Alg_07_968_BinaryTreeCameras {
	private int NOT_MONITORED = 0;
	private int MONITORED_NOCAM = 1;
	private int MONITORED_WITHCAM = 2;
	private int cameras = 0;
	public int minCameraCover(AlgTreeNode root) {
		if (root == null) {
			return 0;
		}
		int top = dfs(root);
		if (top == NOT_MONITORED) {
			cameras++;
		}
		return cameras;
	}
	private int dfs(AlgTreeNode root) {
		if (root == null) {
			return MONITORED_NOCAM;
		}
		int left = dfs(root.left);
		int right = dfs(root.right);
		if (left == MONITORED_NOCAM && right == MONITORED_NOCAM) {
			return NOT_MONITORED;
		}
		else if (left == NOT_MONITORED || right == NOT_MONITORED) {
			cameras++;
			return MONITORED_WITHCAM;
		}
		else {
			return MONITORED_NOCAM;
		}
	}

	public void run() {
		Integer[] arr = new Integer[]{0, 0, null, 0, null, 0, null, null, 0};
		System.out.println(minCameraCover(Util.createTree(arr)));
	}
}
