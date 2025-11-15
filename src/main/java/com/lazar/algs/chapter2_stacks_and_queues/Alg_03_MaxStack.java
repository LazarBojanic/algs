package com.lazar.algs.chapter2_stacks_and_queues;

import com.lazar.algs.common.stack.AlgLinkedListMaxStack;

public class Alg_03_MaxStack {

	public void run(){
		AlgLinkedListMaxStack<Integer> stack = new AlgLinkedListMaxStack<>();
		stack.push(1);
		stack.push(4);
		stack.push(14);
		stack.push(0);
		stack.push(7);
		System.out.println(stack.getMax());
	}
}
