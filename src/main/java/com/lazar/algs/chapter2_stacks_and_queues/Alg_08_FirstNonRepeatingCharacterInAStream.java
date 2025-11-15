package com.lazar.algs.chapter2_stacks_and_queues;

import com.lazar.algs.common.queue.AlgLinkedListQueue;

public class Alg_08_FirstNonRepeatingCharacterInAStream {
	public String firstNonRepeating(String s) {
		int[] freq = new int[26];
		AlgLinkedListQueue<Character> q = new AlgLinkedListQueue<>();
		StringBuilder sb = new StringBuilder();
		for (char ch : s.toCharArray()) {
			freq[ch - 'a']++;
			q.pushBack(ch);
			while (!q.isEmpty() && freq[q.peekFront() - 'a'] > 1) {
				q.popFront();
			}
			if (q.isEmpty()) {
				sb.append('#');
			}
			else {
				sb.append(q.peekFront());
			}
		}
		return sb.toString();
	}
	public void run() {
		System.out.println(firstNonRepeating("abacdeff"));
		System.out.println(firstNonRepeating("aabbcc"));
		System.out.println(firstNonRepeating("aabbcddece"));
	}
}
