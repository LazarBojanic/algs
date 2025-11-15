package com.lazar.algs.chapter4_binary_search;

public class Alg_05_33_SearchInRotatedSortedArray {
	public int search(int[] nums, int target) {
		int left = 0, right = nums.length - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;

			if (nums[mid] == target) {
				return mid;
			}

			if (nums[left] <= nums[mid]) {
				if (nums[left] <= target && target < nums[mid]) {
					right = mid - 1;
				}
				else {
					left = mid + 1;
				}
			}
			else {
				if (nums[mid] < target && target <= nums[right]) {
					left = mid + 1;
				}
				else {
					right = mid - 1;
				}
			}
		}

		return -1;
	}

	public void run() {
		int[] arr1 = {4, 5, 6, 7, 0, 1, 2};
		System.out.println(search(arr1, 0));
		System.out.println(search(arr1, 3));
		int[] arr2 = {1};
		System.out.println(search(arr2, 0));
	}
}
