package com.lazar.algs.tests.test_2022_a;

/*
Time Complexity: O(N^2) - nested loops over all subarrays
Space Complexity: O(1) - only counters and minVal
*/
public class Test_2022_A_Task_2B {
	public int countSubarrays(int[] arr, int T) {
		int N = arr.length;
		int count = 0;
		for (int start = 0; start < N; start++) {
			int minVal = Integer.MAX_VALUE;
			for (int end = start; end < N; end++) {
				minVal = Math.min(minVal, arr[end]);
				if (minVal < T) {
					count++;
				}
			}
		}
		return count;
	}

	public void run() {
		int[] arr = {1, 7, 5, 4, 2, 6};
		int T = 4;
		System.out.println(countSubarrays(arr, T));
	}
}
