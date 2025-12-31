package com.lazar.algs.tests.test_2022_b;

import com.lazar.algs.chapter4_binary_search.Alg_08_MaximizeMinSunflower;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/*
Time Complexity: O(N * log(MaxHeight)) - binary search over min height, each check O(N)
Space Complexity: O(1) - only counters, no extra data structures
*/
public class Test_2022_B_Task_3 {
	public int minimizeDifference(int[] jars, int K) {
		int left = 0;
		int right = 0;
		for (int candy : jars) {
			right = Math.max(right, candy);
		}
		int result = right;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (canAchieve(jars, K, mid)) {
				result = mid;
				left = mid + 1;
			}
			else {
				right = mid - 1;
			}
		}
		int maxJar = Integer.MIN_VALUE;
		for (int candy : jars) {
			maxJar = Math.max(maxJar, candy);
		}
		return maxJar - result;
	}

	private boolean canAchieve(int[] jars, int K, int targetMin) {
		int needed = 0;
		for (int candy : jars) {
			if (candy < targetMin) {
				needed += targetMin - candy;
			}
		}
		return needed <= K;
	}

	public void run() {
		int[] jars = {4, 7, 5, 3, 6};
		int K = 4;
		System.out.println(minimizeDifference(jars, K));
	}
}
