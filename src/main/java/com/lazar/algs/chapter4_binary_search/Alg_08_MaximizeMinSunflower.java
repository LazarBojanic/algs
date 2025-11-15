package com.lazar.algs.chapter4_binary_search;

public class Alg_08_MaximizeMinSunflower {
	public int maximizeMin(int[] heights, int M) {
		int left = Integer.MAX_VALUE;
		for (int h : heights) {
			left = Math.min(left, h);
		}
		int right = left + M;
		int result = left;

		while (left <= right) {
			int mid = left + (right - left) / 2;

			if (canAchieve(heights, M, mid)) {
				result = mid;
				left = mid + 1;
			}
			else {
				right = mid - 1;
			}
		}

		return result;
	}

	private boolean canAchieve(int[] heights, int M, int targetMin) {
		int bottlesNeeded = 0;
		for (int h : heights) {
			if (h < targetMin) {
				bottlesNeeded += targetMin - h;
			}
		}
		return bottlesNeeded <= M;
	}

	public void run() {
		int[] heights = {4, 2, 6, 4};
		int M = 5;
		System.out.println(maximizeMin(heights, M));
	}
}
