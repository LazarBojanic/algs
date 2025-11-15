package com.lazar.algs.chapter2_stacks_and_queues;


public class Alg_07_209_MinimumSizeSubarraySum {
	public int minSubArrayLen(int target, int[] nums) {
		int left = 0;
		int sum = 0;
		int minLen = Integer.MAX_VALUE;

		for (int right = 0; right < nums.length; right++) {
			sum += nums[right];

			while (sum >= target) {
				minLen = Math.min(minLen, right - left + 1);
				sum -= nums[left];
				left++;
			}
		}
		return minLen;
	}
	public void run(){
		int target = 7;
		int[] nums = {2, 3, 1, 2, 4, 3};
		System.out.println(minSubArrayLen(target, nums));
	}
}
