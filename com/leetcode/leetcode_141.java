package com.leetcode;

public class leetcode_141 {

    public boolean hasCycle(ListNode head) {
        //快慢指针检查链表是否无环
        if(head==null||head.next==null||head.next.next == null){
            return false;
        }
        ListNode p1 = head.next;
        ListNode p2 = head.next.next;
        while(p1!=p2){
            if(p1.next!=null){
                p1 = p1.next;
            }else{
                return false;
            }
            if(p2.next!=null&&p2.next.next!=null){
                p2 = p2.next.next;
            }else {
                return false;
            }
        }
        return true;
    }
}
