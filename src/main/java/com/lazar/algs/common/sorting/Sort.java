package com.lazar.algs.common.sorting;

import java.util.Arrays;

public class Sort {

	/**
	 * Bubble Sort
	 * Time Complexity: O(n^2) worst/average, O(n) best (already sorted)
	 * Space Complexity: O(1) - in-place
	 * Stable: Yes
	 */
	public static void bubbleSort(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}

	/**
	 * Insertion Sort
	 * Time Complexity: O(n^2) worst/average, O(n) best (already sorted)
	 * Space Complexity: O(1) - in-place
	 * Stable: Yes
	 */
	public static void insertionSort(int[] arr) {
		int n = arr.length;
		for (int i = 1; i < n; i++) {
			int key = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = key;
		}
	}

	/**
	 * Selection Sort
	 * Time Complexity: O(n^2) for all cases
	 * Space Complexity: O(1) - in-place
	 * Stable: No
	 */
	public static void selectionSort(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			int minIdx = i;
			for (int j = i + 1; j < n; j++) {
				if (arr[j] < arr[minIdx]) {
					minIdx = j;
				}
			}
			int temp = arr[minIdx];
			arr[minIdx] = arr[i];
			arr[i] = temp;
		}
	}

	/**
	 * Merge Sort
	 * Time Complexity: O(n log n) all cases
	 * Space Complexity: O(n) due to temporary arrays
	 * Stable: Yes
	 */
	public static void mergeSort(int[] arr, int left, int right) {
		if (left < right) {
			int mid = left + (right - left) / 2;
			mergeSort(arr, left, mid);
			mergeSort(arr, mid + 1, right);
			merge(arr, left, mid, right);
		}
	}

	private static void merge(int[] arr, int left, int mid, int right) {
		int n1 = mid - left + 1;
		int n2 = right - mid;

		int[] L = new int[n1];
		int[] R = new int[n2];

		for (int i = 0; i < n1; i++) {
			L[i] = arr[left + i];
		}
		for (int i = 0; i < n2; i++) {
			R[i] = arr[mid + 1 + i];
		}

		int i = 0, j = 0, k = left;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			}
			else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}

		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}

	/**
	 * Quick Sort
	 * Time Complexity: O(n log n) average, O(n^2) worst (sorted pivot)
	 * Space Complexity: O(log n) due to recursion
	 * Stable: No
	 */
	public static void quickSort(int[] arr, int low, int high) {
		if (low < high) {
			int pi = partition(arr, low, high);
			quickSort(arr, low, pi - 1);
			quickSort(arr, pi + 1, high);
		}
	}

	private static int partition(int[] arr, int low, int high) {
		int pivot = arr[high];
		int i = low - 1;

		for (int j = low; j < high; j++) {
			if (arr[j] <= pivot) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		int temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;

		return i + 1;
	}

	/**
	 * Heap Sort
	 * Time Complexity: O(n log n) all cases
	 * Space Complexity: O(1) in-place
	 * Stable: No
	 */
	public static void heapSort(int[] arr) {
		int n = arr.length;

		for (int i = n / 2 - 1; i >= 0; i--) {
			heapify(arr, n, i);
		}

		for (int i = n - 1; i >= 0; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			heapify(arr, i, 0);
		}
	}

	private static void heapify(int[] arr, int n, int i) {
		int largest = i;
		int left = 2 * i + 1;
		int right = 2 * i + 2;

		if (left < n) {
			if (arr[left] > arr[largest]) {
				largest = left;
			}
		}

		if (right < n) {
			if (arr[right] > arr[largest]) {
				largest = right;
			}
		}

		if (largest != i) {
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;

			heapify(arr, n, largest);
		}
	}

}
