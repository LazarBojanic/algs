package com.lazar.algs.chapter5_hash_maps;

import java.util.HashMap;

public class Alg_04_560_SubarraySumEqualsK {
	public int subarraySum(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		int sum = 0, count = 0;

		for (int num : nums) {
			sum += num;
			count += map.getOrDefault(sum - k, 0);
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}

		return count;
	}

	public void run() {
		int[] arr = {1, 2, -1, 1, 3};
		int k = 3;
		System.out.println(subarraySum(arr, k));
	}
}
