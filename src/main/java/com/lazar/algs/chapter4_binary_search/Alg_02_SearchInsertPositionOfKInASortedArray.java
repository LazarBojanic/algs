package com.lazar.algs.chapter4_binary_search;

public class Alg_02_SearchInsertPositionOfKInASortedArray {
	public int searchInsert(int[] arr, int k) {
		int left = 0;
		int right = arr.length - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (arr[mid] == k) {
				return mid;
			}
			else if (arr[mid] < k) {
				left = mid + 1;
			}
			else {
				right = mid - 1;
			}
		}
		return left;
	}

	public void run() {
		int[] nums = {-1, 0, 3, 5, 9, 12};
		int target1 = 9;
		int target2 = 2;

		System.out.println(searchInsert(nums, target1));
		System.out.println(searchInsert(nums, target2));
	}
}
