package com.lazar.algs.tests.test_2024_b;

/*
Time Complexity: O(N + K) - each attack is constant, plus counting ships
Space Complexity: O(1) - in-place, no extra data structures
*/
public class Test_2024_B_Task_1 {
	public int countSunkenShips(int[] ships, int K) {
		int N = ships.length;
		int left = 0;
		int right = N - 1;

		while (K > 0 && left <= right) {
			if (ships[left] > 0) {
				ships[left]--;
				K--;
			}
			if (K == 0) {
				break;
			}

			if (ships[right] > 0) {
				ships[right]--;
				K--;
			}

			while (left <= right && ships[left] == 0){
				left++;
			}
			while (left <= right && ships[right] == 0){
				right--;
			}
		}

		int sunken = 0;
		for (int h : ships) if (h == 0){
			sunken++;
		}
		return sunken;
	}

	public void run() {
		int[] ships = {1, 2, 4, 3};
		int K = 5;
		System.out.println(countSunkenShips(ships, K));

		K = 6;
		int[] ships2 = {1, 2, 4, 3};
		System.out.println(countSunkenShips(ships2, K));
	}

}
