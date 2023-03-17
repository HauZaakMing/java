package com.leetcode;

public class leetcode_206 {

    public ListNode reverseList1(ListNode head) {
        if(head == null||head.next==null){
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        while(cur.next!=null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        cur.next = pre;
        return cur;
    }

    public ListNode reverseList(ListNode head) {
        if(head == null||head.next==null){
            return head;
        }
        ListNode newhead= reverseList(head.next);

        head.next.next = head;
        head.next = null;
        return newhead;
    }


}
