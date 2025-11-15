package com.lazar.algs.chapter2_stacks_and_queues;

import com.lazar.algs.common.queue.AlgArrayFullDequeue;

public class Alg_09_DesignFrontMiddleBackQueue {
	public void run() {
		AlgArrayFullDequeue<Integer> fullDequeue = new AlgArrayFullDequeue<>();
		fullDequeue.pushBack(2);
		fullDequeue.pushFront(1);
		fullDequeue.pushFront(0);
		fullDequeue.pushMiddle(3);
		fullDequeue.pushMiddle(4);
		fullDequeue.pushBack(5);
		fullDequeue.pushMiddle(6);
		fullDequeue.pushMiddle(7);
		fullDequeue.pushBack(8);
		fullDequeue.pushMiddle(9);
		fullDequeue.pushBack(10);

	}
}
