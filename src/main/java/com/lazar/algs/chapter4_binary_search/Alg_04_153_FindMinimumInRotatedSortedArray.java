package com.lazar.algs.chapter4_binary_search;

public class Alg_04_153_FindMinimumInRotatedSortedArray {
	public int findMin(int[] nums) {
		int left = 0;
		int right = nums.length - 1;

		while (left < right) {
			int mid = left + (right - left) / 2;

			if (nums[mid] > nums[right]) {
				left = mid + 1;
			}
			else {
				right = mid;
			}
		}
		return nums[left];
	}

	public void run() {
		int[] arr1 = {3, 4, 5, 1, 2};
		int[] arr2 = {4, 5, 6, 7, 0, 1, 2};
		int[] arr3 = {11, 13, 15, 17};

		System.out.println(findMin(arr1));
		System.out.println(findMin(arr2));
		System.out.println(findMin(arr3));
	}
}
