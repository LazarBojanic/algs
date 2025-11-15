package com.lazar.algs.chapter2_stacks_and_queues;


public class Alg_07_209_MinimumSizeSubarraySum {
	public int minSubArrayLen(int target, int[] nums) {
		int left = 0;
		int sum = 0;
		int minLen = nums.length + 1;

		for (int right = 0; right < nums.length; right++) {
			sum += nums[right];

			while (sum >= target) {
				minLen = Math.min(minLen, right - left + 1);
				sum -= nums[left];
				left++;
			}
		}
		if(minLen > nums.length){
			minLen = 0;
		}
		return minLen;
	}

	public void run() {
		int target1 = 7;
		int[] nums1 = {2, 3, 1, 2, 4, 3};
		int target2 = 4;
		int[] nums2 = {1, 4, 4};
		int target3 = 11;
		int[] nums3 = {1, 1, 1, 1, 1, 1, 1, 1};
		System.out.println(minSubArrayLen(target1, nums1));
		System.out.println(minSubArrayLen(target2, nums2));
		System.out.println(minSubArrayLen(target3, nums3));
	}
}
