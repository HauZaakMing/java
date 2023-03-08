package com.leetcode;

import java.util.ListIterator;

public class leetcode_148 {

    public ListNode sortList(ListNode head) {
        //链表的自底向上归并排序
        //先统计链表的长度
        ListNode p = head;
        int length =0;
        while(p!=null){
            length++;
            p=p.next;
        }

        //开始自底向上归并
        ListNode dummy = new ListNode();
        dummy.next = head;
        for (int sublength = 1;sublength< length;sublength=sublength<<1 ){
            ListNode prev = dummy;
            ListNode cur = dummy.next;
            while(cur!=null){
                ListNode h1 = cur;
                for (int i = 1; i < sublength&&cur.next!=null; i++) {
                    cur = cur.next;
                }
                ListNode h2 = cur.next;
                cur.next =null;
                cur = h2;
                for (int i = 1; i < sublength&&cur!=null&&cur.next!=null ; i++) {
                    cur = cur.next;
                }
                ListNode next = null;
                if(cur!=null){
                    next = cur.next;
                    cur.next = null;
                }

                prev.next = mergelist(h1,h2);
                while(prev.next!=null){
                    prev = prev.next;
                }

                cur = next;
            }
        }

        return dummy.next;

    }

    public static ListNode mergelist(ListNode cur1, ListNode cur2){
        ListNode fakehead = new ListNode();
        ListNode tail = fakehead;
        if(cur2==null){
            return cur1;
        }
        if(cur1.val<cur2.val){
            fakehead.next = cur1;
            cur1 = cur1.next;
            tail = tail.next;
        }else{
            fakehead.next = cur2;
            cur2 = cur2.next;
            tail =tail.next;
        }
        while(cur1!=null&&cur2!=null){
            if(cur1.val< cur2.val){
                tail.next =cur1;
                cur1 = cur1.next;

            }else{
                tail.next=cur2;
                cur2 = cur2.next;

            }
            tail = tail.next;

        }
        while (cur1!=null){
            tail.next =cur1;
            cur1 = cur1.next;
            tail = tail.next;
        }
        while (cur2!=null){
            tail.next =cur2;
            cur2 = cur2.next;
            tail = tail.next;
        }
        return fakehead.next;
    }

    public static void main(String[] args) {
        leetcode_148 demo = new leetcode_148();
        demo.sortList(new ListNode(4,new ListNode(2,new ListNode(1,new ListNode(3)))));
    }
}
