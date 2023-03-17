package com.leetcode;

public class leetcode_25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p1 = head;
        boolean flag = true;
        for (int i = 0; i < k-1 ; i++) {
            if(p1.next!=null){
                p1 = p1.next;
            }else{
                if(i<k-1){
                    flag = false;
                    break;
                }
            }


        }
        ListNode tail = p1;

        ListNode headOfNextGroup = reverseKGroup(p1.next, k);

        if(flag){
            tail.next = null;
            //开始反转自己

            reverse(head,tail);
            head.next = headOfNextGroup;
            return tail;
        }else{
            //不需要反转自己了
            return head;
        }

    }

    public ListNode reverse(ListNode head,ListNode tail){
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = head.next;
        while(next!=null){
            cur.next = pre;
            pre = cur;
            cur = next;
            next = cur.next;
        }
        cur.next = pre;
        return tail;
    }

    public static void main(String[] args) {
        leetcode_25 demo = new leetcode_25();
        demo.reverseKGroup(new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5))))),3);
    }
}
