package com.leetcode;

public class leetcode_92 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right){
            return head;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;
        for (int i = 0; i < left-1 ; i++) {
            pre = pre.next;
        }
        ListNode p = pre;
        for (int i = 0; i < right-left+1; i++) {
            p = p.next;
        }
        ListNode next = null;
        if(p!=null){
            next = p.next;
            p.next= null;
        }


        ListNode n1 = reverse(pre.next);
        pre.next = n1;
        while(n1.next!=null){
            n1 = n1.next;
        }
        n1.next = next;
        return dummy.next;
    }

    public ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = cur.next;
        while (next!=null){
            cur.next = pre;
            pre = cur;
            cur = next;
            next = next.next;
        }
        cur.next = pre;
        return cur;
    }

    public static void main(String[] args) {
        leetcode_92 demo = new leetcode_92();
        demo.reverseBetween(new ListNode(3,new ListNode(5)),1,2);
    }
}
