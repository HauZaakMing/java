package com.leetcode;

public class leetcode_160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;
        int Alen = 0;
        int Blen = 0;
        while (p1 != null) {
            p1 = p1.next;
            Alen++;
        }
        while (p2 != null) {
            p2 = p2.next;
            Blen++;
        }
        int dis = Math.abs(Alen - Blen);
        p1 = headA;
        p2 = headB;
        if (Alen > Blen) {
            while (dis-- > 0) {
                p1 = p1.next;
            }
        } else {
            while (dis-- > 0) {
                p2 = p2.next;
            }
        }
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

}
