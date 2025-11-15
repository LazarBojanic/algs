package com.lazar.algs.chapter2_stacks_and_queues;

import com.lazar.algs.common.stack.AlgArrayStack;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Alg_01_Browser {

	public void run() throws Exception {
		String url = "";
		AlgArrayStack<String> stack = new AlgArrayStack<>();
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		do {
			url = br.readLine();
			if (url.equals("back")) {
				if (!stack.isEmpty()) {
					stack.pop();
				}
				if (!stack.isEmpty()) {
					System.out.println(stack.peek());
				}
				else {
					System.out.println("No previous page");
				}
			}
			else {
				stack.push(url);
				System.out.println(url);
			}
		}
		while (!url.equals("quit"));
	}
}
