package com.lazar.algs.chapter5_hash_maps;

import java.util.HashMap;

public class Alg_06_76_MinimumWindowSubstring {
	public String minWindow(String s, String t) {
		if (s.isEmpty() || t.isEmpty()) {
			return "";
		}

		HashMap<Character, Integer> targetMap = new HashMap<>();
		for (char c : t.toCharArray()) {
			targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
		}

		int left = 0, right = 0, minLen = Integer.MAX_VALUE, minStart = 0;
		int required = targetMap.size();
		int formed = 0;

		HashMap<Character, Integer> windowCounts = new HashMap<>();

		while (right < s.length()) {
			char c = s.charAt(right);
			windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);

			if (targetMap.containsKey(c) && windowCounts.get(c).intValue() == targetMap.get(c).intValue()) {
				formed++;
			}

			while (left <= right && formed == required) {
				if (right - left + 1 < minLen) {
					minLen = right - left + 1;
					minStart = left;
				}

				char leftChar = s.charAt(left);
				windowCounts.put(leftChar, windowCounts.get(leftChar) - 1);
				if (targetMap.containsKey(leftChar) && windowCounts.get(leftChar) < targetMap.get(leftChar)) {
					formed--;
				}
				left++;
			}

			right++;
		}

		if (minLen == Integer.MAX_VALUE) {
			return "";
		}
		else{
			return s.substring(minStart, minStart + minLen);
		}
	}

	public void run() {
		String s = "ADOBECODEBANC";
		String t = "ABC";
		System.out.println(minWindow(s, t));
	}
}
