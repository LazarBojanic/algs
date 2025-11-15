package com.lazar.algs.chapter2_stacks_and_queues;

import com.lazar.algs.common.stack.AlgArrayStack;

import java.util.Arrays;

public class Alg_04_ClosestGreaterSuccessor {
	public int[] closestGreaterSuccessors(int[] arr) {
		int n = arr.length;
		int[] result = new int[n];
		AlgArrayStack<Integer> stack = new AlgArrayStack<>(n);
		for (int i = n - 1; i >= 0; i--) {
			while (!stack.isEmpty() && stack.peek() <= arr[i]) {
				stack.pop();
			}
			if (stack.isEmpty()) {
				result[i] = -1;
			}
			else {
				result[i] = stack.peek();
			}
			stack.push(arr[i]);
		}
		return result;
	}

	public void run() {
		int[] arr = {6, 2, 11, 2, 7, 3, 15};
		int[] result = closestGreaterSuccessors(arr);
		System.out.println(Arrays.toString(result));
	}
}
