package com.lazar.algs.tests.test_2024_b;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
	Time Complexity: O(C log maxValue)
	Space Complexity: O(C)
   */
public class Test_2024_B_Task_3 {
	public int[] redistributeCookies(int[] cookies, int N) {
		int C = cookies.length;
		int[] result = Arrays.copyOf(cookies, C);

		int hearts = result[C - 1];

		PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
			(a, b) -> b[0] - a[0]
		);

		for (int i = 0; i < C - 1; i++) {
			maxHeap.offer(new int[]{result[i], i});
		}

		while (N > 0 && !maxHeap.isEmpty()) {
			int[] top = maxHeap.poll();

			if (top[0] == 0) break;

			top[0]--;
			result[top[1]] = top[0];

			maxHeap.offer(top);
			N--;
		}

		result[C - 1] = hearts;

		return result;
	}

	public void run() {
		int N = 63;
		int[] cookies = {14, 42, 33, 32, 69};
		System.out.println(Arrays.toString(redistributeCookies(cookies, N)));
	}
}
