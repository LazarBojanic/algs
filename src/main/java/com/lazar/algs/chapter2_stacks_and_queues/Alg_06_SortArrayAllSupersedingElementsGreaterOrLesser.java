package com.lazar.algs.chapter2_stacks_and_queues;

import com.lazar.algs.common.AlgArrayDequeue;

public class Alg_06_SortArrayAllSupersedingElementsGreaterOrLesser {
	public Integer[] sort(int[] array) {
		AlgArrayDequeue<Integer> dequeue = new AlgArrayDequeue<>();
		for (int element : array) {
			if (element < dequeue.peekFirst()) {
				dequeue.pushFirst(element);
			}
			else {
				dequeue.pushLast(element);
			}
		}
		return dequeue.getArr();
	}
}
