package com.lazar.algs.common.binary_tree;

import com.lazar.algs.common.Util;
import com.lazar.algs.common.queue.AlgArrayQueue;
import com.lazar.algs.common.stack.AlgArrayStack;

import java.util.ArrayList;
import java.util.List;

public class Traversal {
	public void dfsIterative(AlgTreeNode root) {
		if (root == null) return;
		AlgArrayStack<AlgTreeNode> stack = new AlgArrayStack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			AlgTreeNode node = stack.pop();
			System.out.print(node.val + " ");
			if (node.right != null) {
				stack.push(node.right);
			}
			if (node.left != null) {
				stack.push(node.left);
			}
		}
	}
	public void dfsRecursive(AlgTreeNode root) {
		if (root == null) return;
		System.out.print(root.val + " ");
		dfsRecursive(root.left);
		dfsRecursive(root.right);
	}
	public void bfsIterative(AlgTreeNode root) {
		if (root == null) {
			return;
		}
		AlgArrayQueue<AlgTreeNode> queue = new AlgArrayQueue<>();
		queue.pushBack(root);
		while (!queue.isEmpty()) {
			AlgTreeNode node = queue.popFront();
			System.out.print(node.val + " ");
			if (node.left != null) {
				queue.pushBack(node.left);
			}
			if (node.right != null) {
				queue.pushBack(node.right);
			}
		}
	}
	public void bfsRecursive(AlgTreeNode root) {
		if (root == null) {
			return;
		}
		List<AlgTreeNode> level = List.of(root);
		bfsLevel(level);
	}

	private void bfsLevel(List<AlgTreeNode> level) {
		if (level.isEmpty()) {
			return;
		}
		List<AlgTreeNode> next = new ArrayList<>();
		for (AlgTreeNode node : level) {
			System.out.print(node.val + " ");
			if (node.left != null) {
				next.add(node.left);
			}
			if (node.right != null) {
				next.add(node.right);
			}
		}
		bfsLevel(next);
	}

	public void run(){
		Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
		AlgTreeNode root = Util.createTree(arr);
		dfsIterative(root);
		System.out.println();
		dfsRecursive(root);
		System.out.println();
		bfsIterative(root);
		System.out.println();
		bfsRecursive(root);
	}
}
