package com.leetcode;

public class leetcode_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // 长数计算，要注意不要使用int类型存放最后的答案
        ListNode p1 = l1;
        ListNode p2 = l2;

        ListNode ansL = new ListNode();
        ListNode p = ansL;

        int currentV = 0;
        int nextV = 0;
        while (p1 != null && p2 != null) {
            int n1 = p1.val;
            int n2 = p2.val;
            currentV = (n1 + n2 + nextV) % 10;
            nextV = (n1 + n2 + nextV) / 10;

            p.next = new ListNode(currentV, null);
            p = p.next;
            p1 = p1.next;
            p2 = p2.next;
        }

        while (p1 != null) {
            int n1 = p1.val;

            currentV = (n1 + nextV) % 10;
            nextV = (n1 + nextV) / 10;

            p.next = new ListNode(currentV, null);
            p = p.next;
            p1 = p1.next;

        }

        while (p2 != null) {
            int n2 = p2.val;

            currentV = (n2 + nextV) % 10;
            nextV = (n2 + nextV) / 10;

            p.next = new ListNode(currentV, null);
            p = p.next;
            p2 = p2.next;

        }

        if (nextV != 0) {
            p.next = new ListNode(nextV, null);
            p = p.next;
        }

        return ansL.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9, null);
        ListNode l2 = new ListNode(1, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9,
                new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, null))))))))));
        leetcode_2 demo = new leetcode_2();
        demo.addTwoNumbers(l1, l2);
    }
}
