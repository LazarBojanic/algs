package com.lazar.algs.chapter4_binary_search;

import java.util.Arrays;

public class Alg_09_AggressiveCows {
	public int largestMinDistance(int[] stalls, int C) {
		Arrays.sort(stalls);
		int left = 1;
		int right = stalls[stalls.length - 1] - stalls[0];
		int result = 0;

		while (left <= right) {
			int mid = left + (right - left) / 2;

			if (canPlaceCows(stalls, C, mid)) {
				result = mid;
				left = mid + 1;
			}
			else {
				right = mid - 1;
			}
		}

		return result;
	}

	private boolean canPlaceCows(int[] stalls, int C, int minDist) {
		int count = 1;
		int lastPos = stalls[0];

		for (int i = 1; i < stalls.length; i++) {
			if (stalls[i] - lastPos >= minDist) {
				count++;
				lastPos = stalls[i];
				if (count == C) return true;
			}
		}

		return false;
	}

	public void run() {
		int[] stalls1 = {1, 2, 8, 4, 9};
		int C1 = 3;
		System.out.println(largestMinDistance(stalls1, C1));

		int[] stalls2 = {0, 3, 4, 7, 10};
		int C2 = 4;
		System.out.println(largestMinDistance(stalls2, C2));
	}
}
