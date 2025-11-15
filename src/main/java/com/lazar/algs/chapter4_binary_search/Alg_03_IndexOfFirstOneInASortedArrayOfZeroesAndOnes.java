package com.lazar.algs.chapter4_binary_search;

public class Alg_03_IndexOfFirstOneInASortedArrayOfZeroesAndOnes {
	public int firstOne(int[] arr) {
		int left = 0;
		int right = arr.length - 1;
		int result = -1;

		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (arr[mid] == 1) {
				result = mid;
				right = mid - 1;
			}
			else {
				left = mid + 1;
			}
		}
		return result;
	}

	public void run() {
		int[] arr1 = {0, 0, 0, 1, 1, 1};
		int[] arr2 = {0, 0, 0, 0};
		int[] arr3 = {1, 1, 1, 1};
		int[] arr4 = {0, 0, 0, 0, 1, 1};

		System.out.println(firstOne(arr1));
		System.out.println(firstOne(arr2));
		System.out.println(firstOne(arr3));
		System.out.println(firstOne(arr4));
	}
}
