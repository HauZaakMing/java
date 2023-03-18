package com.leetcode;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class leetcode_23 {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length==0){
            return null;
        }
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.len));
        for (ListNode n :
                lists) {
            int len = countLen(n);
            Node temp = new Node(n,len);
            queue.add(temp);
        }
        while (queue.size() > 1) {
            Node n1 = queue.poll();
            Node n2 = queue.poll();
            ListNode n3 = merge(n1.n, n2.n);
            queue.add(new Node(n3,n1.len+n2.len));
        }
        return queue.poll().n;
    }

    public ListNode merge(ListNode n1, ListNode n2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (n1 != null && n2 != null) {
            if (n1.val < n2.val) {

                cur.next = n1;
                cur = cur.next;
                n1 = n1.next;
            } else {
                cur.next = n2;
                cur = cur.next;
                n2 = n2.next;
            }
        }

        while (n1 != null) {
            cur.next = n1;
            cur = cur.next;
            n1 = n1.next;
        }
        while (n2 != null) {
            cur.next = n2;
            cur = cur.next;
            n2 = n2.next;
        }
        return dummy.next;
    }


    public int countLen(ListNode n1) {
        int count = 0;
        while(n1!=null){
            n1 = n1.next;
            count++;
        }
        return count;
    }

    class Node {
        ListNode n;
        int len;

        public Node(ListNode n, int len) {
            this.n = n;
            this.len = len;
        }
    }
}
