package com.sword2offer;



public class q_22 {
    //剑指 Offer 22. 链表中倒数第k个节点
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode p1 = dummy;
        ListNode p2 = dummy;
        for (int i = 0; i < k; i++) {
            p2 = p2.next;
        }
        while (p2!=null){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}
