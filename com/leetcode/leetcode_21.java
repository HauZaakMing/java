package com.leetcode;

public class leetcode_21 {


    public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        ListNode dummyhead = new ListNode();
        ListNode cur = dummyhead;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
                cur = cur.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
                cur = cur.next;
            }
        }
        while (list1 != null) {
            cur.next = list1;
            list1 = list1.next;
            cur = cur.next;
        }
        while (list2 != null) {
            cur.next = list2;
            list2 = list2.next;
            cur = cur.next;
        }
        return dummyhead.next;
    }

    //要是有空间复杂度的要求，头比较小的作为最后返回的head，做链表插入


}
