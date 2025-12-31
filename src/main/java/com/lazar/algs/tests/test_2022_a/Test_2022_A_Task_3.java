package com.lazar.algs.tests.test_2022_a;

import com.lazar.algs.chapter4_binary_search.Alg_08_MaximizeMinSunflower;

/*
Time Complexity: O(N * log(M + minHeight)) - binary search over answer, each check O(N)
Space Complexity: O(1) - only counters
*/
public class Test_2022_A_Task_3 {
	public void run() {
		Alg_08_MaximizeMinSunflower alg = new Alg_08_MaximizeMinSunflower();
		int[] heights = {4, 2, 6, 4};
		int M = 5;
		System.out.println(alg.maximizeMin(heights, M));
	}
}
