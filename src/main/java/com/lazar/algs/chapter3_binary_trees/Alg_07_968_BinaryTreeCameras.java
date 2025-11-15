package com.lazar.algs.chapter3_binary_trees;

import com.lazar.algs.common.Util;
import com.lazar.algs.common.binary_tree.AlgTreeNode;

public class Alg_07_968_BinaryTreeCameras {
	private int cameras = 0;

	public int minCameraCover(AlgTreeNode root) {
		if (dfs(root) == 0) {
			cameras++;
		}
		return cameras;
	}

	private int dfs(AlgTreeNode node) {
		if (node == null) {
			return 2;
		}

		int left = dfs(node.left);
		int right = dfs(node.right);

		if (left == 0 || right == 0) {
			cameras++;
			return 1;
		}
		else if (left == 1 || right == 1) {
			return 2;
		}
		else {
			return 0;
		}
	}
	public void run(){
		Integer[] arr = new Integer[] { 0, 0, null, 0, null, 0, null, null, 0 };
		System.out.println(minCameraCover(Util.createTree(arr)));
	}
}
