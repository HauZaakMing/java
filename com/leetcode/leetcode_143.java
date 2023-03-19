package com.leetcode;

public class leetcode_143 {

    public void reorderList(ListNode head) {
        if(head==null||head.next==null||head.next.next==null){
            return;
        }
        //先使用快慢指针切成两半
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode p1 = dummy;
        ListNode p2 = dummy;
        while(p2.next!=null&&p2.next.next!=null){
            p2 = p2.next.next;
            p1 = p1.next;
        }
        if(p2.next!=null){
            p1 = p1.next;
        }
        ListNode re = p1.next;
        p1.next = null;
        re = reverse(re);
        merge(head,re);

    }
    public ListNode reverse(ListNode re){
        ListNode pre =null;
        ListNode cur = re;
        ListNode next = re.next;
        while(next!=null){
            cur.next = pre;
            pre = cur;
            cur = next;
            next = cur.next;
        }
        cur.next = pre;
        return cur;
    }

    //n1是长的，合并到n1上
    public void merge(ListNode n1, ListNode n2){
        ListNode cur = n1;
        while (n2!=null){
            ListNode temp = n2.next;
            n2.next = cur.next;
            cur.next = n2;
            cur = cur.next.next;
            n2 = temp;
        }
    }

    public static void main(String[] args) {
        leetcode_143 demo = new leetcode_143();
        demo.reorderList(new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4)))));
    }

}
