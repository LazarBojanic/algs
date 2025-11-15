package com.lazar.algs.chapter4_binary_search;

public class Alg_07_AllocateBooks {
	public int books(int[] A, int B) {
		if (B > A.length) return -1;

		int left = 0, right = 0;
		for (int pages : A) {
			left = Math.max(left, pages);
			right += pages;
		}

		int result = right;

		while (left <= right) {
			int mid = left + (right - left) / 2;

			if (isPossible(A, B, mid)) {
				result = mid;
				right = mid - 1;
			}
			else {
				left = mid + 1;
			}
		}

		return result;
	}

	private boolean isPossible(int[] A, int B, int maxPages) {
		int students = 1;
		int sum = 0;

		for (int pages : A) {
			if (pages > maxPages) return false;
			if (sum + pages > maxPages) {
				students++;
				sum = pages;
			}
			else {
				sum += pages;
			}
		}

		return students <= B;
	}

	public void run() {
		int[] books = {12, 34, 67, 90};
		int students = 2;
		System.out.println(books(books, students));
	}
}
