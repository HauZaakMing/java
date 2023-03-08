package com.leetcode;

public class leetcode_142 {

    public ListNode detectCycle(ListNode head) {
        if(head==null||head.next==null||head.next.next == null){
            return null;
        }
        ListNode p1 = head.next;
        ListNode p2 = head.next.next;
        while(p1!=p2){
            if(p1.next!=null){
                p1 = p1.next;
            }else{
                return null;
            }
            if(p2.next!=null&&p2.next.next!=null){
                p2 = p2.next.next;
            }else {
                return null;
            }
        }
        //有环
        p2 = head;
        while(p2!=p1){
            p2 = p2.next;
            p1 = p1.next;
        }
        return p1;
    }
}
