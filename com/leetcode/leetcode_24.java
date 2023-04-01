package com.leetcode;

public class leetcode_24 {
    public ListNode swapPairs(ListNode head) {
        ListNode p1 = new ListNode();
        ListNode p1_tail = p1;
        ListNode p2 = new ListNode();
        ListNode p2_tail = p2;
        ListNode p = head;
        while (p!=null){
            p1_tail.next = p;
            p1_tail = p1_tail.next;
            p = p.next;
            if(p!=null){
                p2_tail.next = p;
                p2_tail = p2_tail.next;
                p = p.next;
            }
        }
        p1_tail.next = null;
        p2_tail.next = null;
        p1 = p1.next;
        p2 = p2.next;
        //merge
        ListNode dummy = new ListNode();
        p = dummy;
        while (p2!=null){

            p.next = p2;
            p2 = p2.next;
            p = p.next;
            p.next = p1;
            p1 = p1.next;
            p = p.next;
        }
        if(p1!=null){
            p.next = p1;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        leetcode_24 demo =new leetcode_24();
        demo.swapPairs(new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4)))));
    }
}
