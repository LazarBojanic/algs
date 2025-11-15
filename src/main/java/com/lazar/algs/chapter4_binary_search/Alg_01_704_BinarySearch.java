package com.lazar.algs.chapter4_binary_search;

public class Alg_01_704_BinarySearch {
	public int binarySearch(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] == target) {
				return mid;
			}
			else if (nums[mid] < target) {
				left = mid + 1;
			}
			else {
				right = mid - 1;
			}
		}

		return -1;
	}

	public void run() {
		int[] nums = {-1, 0, 3, 5, 9, 12};
		int target1 = 9;
		int target2 = 2;

		System.out.println(binarySearch(nums, target1));
		System.out.println(binarySearch(nums, target2));
	}
}
