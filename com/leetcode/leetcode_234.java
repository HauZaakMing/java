package com.leetcode;

import java.security.DrbgParameters;

public class leetcode_234 {

    public boolean isPalindrome(ListNode head) {
        if(head.next==null){
            return true;
        }
        ListNode fakeHead = new ListNode();
        fakeHead.next = head;
        ListNode p1 = fakeHead;
        ListNode p2 = fakeHead;


        while(p2.next!=null&&p2.next.next!=null){
            p1 = p1.next;
            p2 = p2.next.next;
        }
        while(p2.next!=null){
            p1=p1.next;
            p2=p2.next;
        }
        ListNode pre = null;
        ListNode cur = p1.next;

        while(cur!=null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        p1 = fakeHead.next;
        p2 = pre;
        while(p2!= null){
            if(p2.val!=p1.val){
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }
}
