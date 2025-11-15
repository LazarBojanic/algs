package com.lazar.algs.chapter2_stacks_and_queues;

import com.lazar.algs.common.AlgArrayStack;

public class Alg_04_ClosestGreaterSuccessor {
	public int[] closestGreaterSuccessors(int[] arr) {
		AlgArrayStack<Integer> stack = new AlgArrayStack<>(arr.length);
		for (int i = arr.length - 1; i >= 0; i--) {
			while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
				stack.pop();
			}
			if (stack.isEmpty()) {
				arr[i] = -1;
			}
			else {
				arr[i] = stack.peek();
			}
			stack.push(i);
		}
		return arr;
	}
}
