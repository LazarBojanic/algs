package com.lazar.algs.chapter5_hash_maps;

import java.util.HashMap;

public class Alg_03_MaxDistanceBetweenSameElements {
	public int maxDistance(int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int maxDist = 0;
		for (int i = 0; i < arr.length; i++) {
			if (!map.containsKey(arr[i])) {
				map.put(arr[i], i);
			}
			else {
				maxDist = Math.max(maxDist, i - map.get(arr[i]));
			}
		}
		return maxDist;
	}

	public void run() {
		int[] arr = {1, 1, 2, 2, 2, 1};
		System.out.println(maxDistance(arr));
	}
}
