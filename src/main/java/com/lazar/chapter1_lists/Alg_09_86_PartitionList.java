package com.lazar.chapter1_lists;

import com.lazar.common.ListNode;

public class Alg_09_86_PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode beforeHead = new ListNode(0);
        ListNode before = beforeHead;
        ListNode afterHead = new ListNode(0);
        ListNode after = afterHead;
        while (head != null) {
            if (head.val < x) {
                before.next = head;
                before = before.next;
            }
            else {
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }
        before.next = afterHead.next;
        after.next = null;
        return beforeHead.next;
    }
}
