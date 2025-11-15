package com.lazar.algs.chapter2_stacks_and_queues;

import com.lazar.algs.common.queue.AlgArrayDequeue;

import java.util.Arrays;

public class Alg_06_SortArrayAllSupersedingElementsGreaterOrLesser {
	public Integer[] sort(int[] array) {
		AlgArrayDequeue<Integer> dequeue = new AlgArrayDequeue<>();
		for (int element : array) {
			if (dequeue.isEmpty() || element >= dequeue.peekBack()) {
				dequeue.pushBack(element);
			}
			else {
				dequeue.pushFront(element);
			}
		}
		Integer[] result = new Integer[dequeue.size()];
		for (int i = 0; i < result.length; i++) {
			result[i] = dequeue.popFront();
		}
		return result;
	}

	public void run() {
		int[] array = {5, 8, 12, 4, 2, 13, 19, 1};
		Integer[] result = sort(array);
		System.out.println(Arrays.toString(result));
	}
}
