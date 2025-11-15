package com.lazar.algs.chapter5_hash_maps;

import java.util.HashMap;

public class Alg_05_242_ValidAnagram {
	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) return false;

		HashMap<Character, Integer> map = new HashMap<>();
		for (char c : s.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
		for (char c : t.toCharArray()) {
			if (!map.containsKey(c)) {
				return false;
			}
			map.put(c, map.get(c) - 1);
			if (map.get(c) == 0) {
				map.remove(c);
			}
		}

		return map.isEmpty();
	}

	public void run() {
		System.out.println(isAnagram("anagram", "nagaram"));
		System.out.println(isAnagram("rat", "car"));
	}
}
