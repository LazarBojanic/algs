package com.lazar.algs.chapter5_hash_maps;

import java.util.Arrays;
import java.util.HashMap;

public class Alg_02_1_TwoSum {
	public int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (map.containsKey(complement)) {
				return new int[]{map.get(complement), i};
			}
			map.put(nums[i], i);
		}
		return new int[0];
	}

	public void run() {
		int[] arr = {1, 2, 7, 4, 3};
		int target = 10;
		int[] result = twoSum(arr, target);
		System.out.println(Arrays.toString(result));
	}
}
