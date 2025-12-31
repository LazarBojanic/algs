package com.lazar.algs.tests.test_2022_b;

/*
Time Complexity: O(N) - single pass
Space Complexity: O(1) - only counters
*/
public class Test_2022_B_Task_2B {
	public int longestBeautiful(int[] arr, int T) {
		int maxLen = 0;
		int currentLen = 0;
		for (int val : arr) {
			if (val < T) {
				currentLen++;
				maxLen = Math.max(maxLen, currentLen);
			}
			else {
				currentLen = 0;
			}
		}
		return maxLen;
	}

	public void run() {
		int[] arr = {1, 7, 3, 4, 2, 4, 6};
		int T = 5;
		System.out.println(longestBeautiful(arr, T));
	}
}
