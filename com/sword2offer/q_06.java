package com.sword2offer;

public class q_06 {
    int count =0;
    //剑指 Offer 06. 从尾到头打印链表
    public int[] reversePrint(ListNode head) {
        int []ans;
        if(head==null){
            return new int[]{};
        } else if (head.next==null) {
            return new int[]{head.val};
        }else{
            ListNode re = reverse(head);
            ans = new int[count+1];
            for (int i = 0; i < count+1; i++) {
                ans[i] = re.val;
                re = re.next;
            }
        }
        return ans;
    }


    public ListNode reverse(ListNode node){

        ListNode pre = null;
        ListNode cur = node;
        ListNode next = node.next;
        while(next!=null){
            cur.next = pre;
            pre = cur;

            cur = next;
            next = next.next;
            count++;
        }
        cur.next = pre;
        return cur;
    }
}
