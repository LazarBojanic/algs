package com.lazar.algs.chapter1_lists;

import com.lazar.algs.common.AlgListNode;
import com.lazar.algs.common.Util;

import java.util.ArrayList;
import java.util.List;

public class Alg_06_234_PalindromeLinkedList {
    public <T> boolean isPalindrome(AlgListNode<T> head) {
        List<T> vals = new ArrayList<>();
        AlgListNode<T> curr = head;
        while (curr != null) {
            vals.add(curr.val);
            curr = curr.next;
        }
        int front = 0;
        int back = vals.size() - 1;
        while (front < back) {
            if (!vals.get(front).equals(vals.get(back))) {
                return false;
            }
            front++;
            back--;
        }
        return true;
    }
	public void run(){
		AlgListNode<Integer> list = Util.createLinkedList(1, 2, 3, 4, 5);
		boolean palindrome = isPalindrome(list);
		System.out.println("Is palindrome: " + palindrome);
	}
}
