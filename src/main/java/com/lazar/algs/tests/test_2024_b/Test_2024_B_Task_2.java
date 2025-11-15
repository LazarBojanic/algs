package com.lazar.algs.tests.test_2024_b;

import com.lazar.algs.common.Util;
import com.lazar.algs.common.binary_tree.AlgTreeNode;

import java.util.ArrayList;
import java.util.List;

/*
Time Complexity: O(N * D) - N nodes, D = max depth (digits in numbers along paths)
Space Complexity: O(N * D) - storing numbers from leaf->node
*/
public class Test_2024_B_Task_2 {
	private int count = 0;

	public int countBeautiful(AlgTreeNode root) {
		if (root == null) return 0;
		helper(root, 0);
		return count;
	}

	private List<Integer> helper(AlgTreeNode node, int rootToNodeNum) {
		if (node == null) return new ArrayList<>();

		rootToNodeNum = rootToNodeNum * 10 + node.val;

		if (node.left == null && node.right == null) {
			List<Integer> leafNums = new ArrayList<>();
			leafNums.add(node.val);
			return leafNums;
		}

		List<Integer> leafNumbers = new ArrayList<>();
		List<Integer> leftLeaves = helper(node.left, rootToNodeNum);
		List<Integer> rightLeaves = helper(node.right, rootToNodeNum);

		for (int num : leftLeaves) {
			int digits = countDigits(num);
			leafNumbers.add(node.val * (int) Math.pow(10, digits) + num);
		}
		for (int num : rightLeaves) {
			int digits = countDigits(num);
			leafNumbers.add(node.val * (int) Math.pow(10, digits) + num);
		}

		int maxEven = Integer.MIN_VALUE;
		for (int num : leafNumbers) {
			if (num % 2 == 0) maxEven = Math.max(maxEven, num);
		}

		if (rootToNodeNum % 2 == 0 && rootToNodeNum < maxEven) {
			count++;
		}

		return leafNumbers;
	}

	private int countDigits(int num) {
		if (num == 0) return 1;
		int digits = 0;
		while (num > 0) {
			num /= 10;
			digits++;
		}
		return digits;
	}

	public void run() {
		Integer[] arr = {6, 6, 4, 8, 1, 2, 5, null, null, null, null, 9};
		AlgTreeNode root = Util.createTree(arr);
		System.out.println(countBeautiful(root));
	}
}
