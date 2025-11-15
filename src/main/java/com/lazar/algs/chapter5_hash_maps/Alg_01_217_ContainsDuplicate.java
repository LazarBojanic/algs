package com.lazar.algs.chapter5_hash_maps;

import java.util.HashSet;

public class Alg_01_217_ContainsDuplicate {
	public boolean containsDuplicate(int[] nums) {
		HashSet<Integer> set = new HashSet<>();
		for (int num : nums) {
			if (!set.add(num)) {
				return true;
			}
		}
		return false;
	}

	public void run() {
		int[] arr1 = {1, 2, 3, 1};
		int[] arr2 = {1, 2, 3, 4};
		System.out.println(containsDuplicate(arr1));
		System.out.println(containsDuplicate(arr2));
	}
}
