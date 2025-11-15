package com.lazar.algs.chapter4_binary_search;

public class Alg_06_1539_KthMissingPositiveNumber {
	public int findKthPositive(int[] arr, int k) {
		int left = 0, right = arr.length - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;
			int missingBefore = arr[mid] - (mid + 1);

			if (missingBefore < k) {
				left = mid + 1;
			}
			else {
				right = mid - 1;
			}
		}
		return k + left;
	}

	public void run() {
		int[] arr1 = {2, 3, 4, 7, 11};
		int k1 = 5;
		System.out.println(findKthPositive(arr1, k1));
		int[] arr2 = {1, 2, 3, 4};
		int k2 = 2;
		System.out.println(findKthPositive(arr2, k2));
	}
}
