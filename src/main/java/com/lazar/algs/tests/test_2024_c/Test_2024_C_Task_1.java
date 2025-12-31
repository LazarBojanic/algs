package com.lazar.algs.tests.test_2024_c;

public class Test_2024_C_Task_1 {
	public int countTeams(int[] a) {
		int n = a.length;
		int count = 0;
		for (int i = 0; i < n; i++) {
			int left = i + 1;
			int right = n - 1;
			while (left < right) {
				int sum = a[i] + a[left] + a[right];
				if (sum == 0) {
					if (a[left] == a[right]) {
						int k = right - left + 1;
						count += (k * (k - 1)) / 2;
						break;
					}
					int lv = a[left];
					int rv = a[right];
					int counterLeft = 0;
					while (left < right && a[left] == lv) {
						left++;
						counterLeft++;
					}
					int counterRight = 0;
					while (left < right && a[right] == rv) {
						right--;
						counterRight++;
					}
					count += counterLeft * counterRight;
				}
				else if (sum < 0) {
					left++;
				}
				else {
					right--;
				}
			}
		}
		return count;
	}

	public void run() {
		int[] a = {-30, -5, 2, 2, 3};
		System.out.println(countTeams(a));
	}
}
