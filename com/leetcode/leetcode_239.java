package com.leetcode;

import java.util.LinkedList;

// 2023.3.3
public class leetcode_239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        // 滑动窗口最大值
        // 双端队列仅会保存当前窗口的最大值和，该最大值后来的数
        // 如果后来的数很大，那直接可以将前面较小的挤出去，因为他们肯定没法成为窗口最大值
        // 小的则先存着，有可能大的数字走掉后，他可能会成为大的

        int[] ans = new int[nums.length - k + 1];
        LinkedList<Integer> DHeadList = new LinkedList<>();
        int r = 0;
        int l = 0;

        while (r < nums.length) {

            if (l > 0) {
                if (DHeadList.peekFirst() == l - 1) {
                    DHeadList.pollFirst();
                }
            }

            if (DHeadList.isEmpty()) {
                DHeadList.add(r);

            } else {
                if (nums[r] < nums[DHeadList.peekLast()]) {
                    DHeadList.add(r);
                } else {
                    while (!DHeadList.isEmpty() && nums[r] >= nums[DHeadList.peekLast()]) {
                        DHeadList.pollLast();
                    }
                    DHeadList.add(r);
                }
            }
            if (r >= k - 1) {
                ans[r - k + 1] = nums[DHeadList.peekFirst()];
            }

            r++;
            if (r >= k) {
                l++;
            }
        }

        if (k == nums.length) {
            return new int[] { nums[DHeadList.pollFirst()] };
        } else {
            return ans;
        }

    }

    public static void main(String[] args) {
        leetcode_239 demo = new leetcode_239();
        demo.maxSlidingWindow(new int[] { 1, -1 }, 1);
    }
}
