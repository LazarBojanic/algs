package com.lazar.algs.chapter2_stacks_and_queues;

import com.lazar.algs.common.AlgLinkedListQueue;

public class Alg_08_FirstNonRepeatingCharacterInAStream {
	public String firstNonRepeating(String s) {
		int[] freq = new int[26];
		AlgLinkedListQueue<Character> q = new AlgLinkedListQueue<>();

		StringBuilder sb = new StringBuilder();
		for (char ch : s.toCharArray()) {
			freq[ch - 'a']++;
			q.pushLast(ch);
			while (!q.isEmpty() && freq[q.peekFirst() - 'a'] > 1) {
				q.popFirst();
			}

			if (q.isEmpty()) {
				sb.append('#');
			}
			else {
				sb.append(q.peekFirst());
			}
		}

		return sb.toString();
	}
}
