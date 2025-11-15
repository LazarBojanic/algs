package com.lazar.algs.chapter2_stacks_and_queues;

import com.lazar.algs.common.AlgArrayStack;

public class Alg_02_Parentheses {
	public boolean isValid(String s) {
		boolean result = true;
		AlgArrayStack<Character> stack = new AlgArrayStack<>(100);
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(' || c == '[' || c == '{') {
				stack.push(c);
			}
			else if (c == ')' || c == ']' || c == '}') {
				if (stack.isEmpty()) {
					result = false;
				}
				else if (!stack.peek().equals(invert(c))) {
					result = false;
				}
				else {
					stack.pop();
				}
			}
		}
		if (!stack.isEmpty()) {
			result = false;
		}
		return result;
	}

	private char invert(char c) {
		if (c == '(') {
			return ')';
		}
		else if (c == ')') {
			return '(';
		}
		else if (c == '[') {
			return ']';
		}
		else if (c == ']') {
			return '[';
		}
		else if (c == '{') {
			return '}';
		}
		else if (c == '}') {
			return '{';
		}
		else {
			return ' ';
		}
	}

	public void run() {
		System.out.println(isValid("()[]{}"));
		System.out.println(isValid("{){}]][{}[]"));
		System.out.println(isValid("()[]{)"));
	}
}
