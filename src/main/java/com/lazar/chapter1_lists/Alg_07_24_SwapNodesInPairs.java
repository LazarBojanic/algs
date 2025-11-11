package com.lazar.chapter1_lists;

import com.lazar.common.ListNode;

public class Alg_07_24_SwapNodesInPairs {
    public ListNode swapPairsRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode firstNode = head;
        ListNode secondNode = head.next;
        firstNode.next = swapPairsRecursive(secondNode.next);
        secondNode.next = firstNode;
        return secondNode;
    }
    public ListNode swapPairsIterative(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        while (current.next != null && current.next.next != null) {
            ListNode first = current.next;
            ListNode second = current.next.next;
            first.next = second.next;
            current.next = second;
            current.next.next = first;
            current = current.next.next;
        }
        return dummy.next;
    }
}
