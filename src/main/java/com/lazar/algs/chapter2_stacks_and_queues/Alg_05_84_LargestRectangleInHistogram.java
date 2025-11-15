package com.lazar.algs.chapter2_stacks_and_queues;

import com.lazar.algs.common.AlgArrayStack;

public class Alg_05_84_LargestRectangleInHistogram {

	public int largestRectangleArea(int[] heights) {
		int n = heights.length;
		AlgArrayStack<Integer> stack = new AlgArrayStack<>();
		int maxArea = 0;
		for (int right = 0; right <= n; right++) {
			int h;
			if (right == n) {
				h = 0;
			}
			else {
				h = heights[right];
			}
			while (!stack.isEmpty() && h < heights[stack.peek()]) {
				int height = heights[stack.pop()];
				int left;
				if (stack.isEmpty()) {
					left = 0;
				}
				else {
					left = stack.peek() + 1;
				}
				int width = right - left;
				maxArea = Math.max(maxArea, height * width);
			}
			stack.push(right);
		}
		return maxArea;
	}
}
