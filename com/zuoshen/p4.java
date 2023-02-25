package com.zuoshen;

public class p4 {

    public static void main(String[] args) {
        p4 demo = new p4();
        demo.t2();
    }

    // public static void t1(int[] nums) {
    // // 小和问题的普通解法
    // // int[] nums = dwq.generateRandomArray(5, 10, 100);
    // for (int i : nums) {
    // System.out.print(i + " ");
    // }
    // System.out.println();
    // int[] ans = new int[nums.length];
    // ans[0] = 0;
    // for (int i = 1; i < ans.length; i++) {
    // int cur = nums[i];
    // int p = i - 1;
    // while (p >= 0 && nums[p] > cur) {
    // p = p - 1;
    // }
    // if (p != -1) {
    // ans[i] = ans[p] + nums[p];
    // } else {
    // ans[i] = 0;
    // }

    // }
    // System.out.println("输出结果");
    // for (int i : ans) {
    // System.out.print(i + " ");
    // }
    // System.out.println();
    // }

    public void t2() {
        // 小和问题的进阶解法，利用归并
        // int[] nums = dwq.generateRandomArray(5, 5, 10);
        int[] nums = { -7, 1, 7, 1, 0 };
        // t1(nums);
        System.out.println("++++++++++++++++");
        for (int i : nums) {
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.println(process(nums, 0, nums.length - 1));

    }

    // 递归编程模板
    // 递归启动器
    public int process(int[] nums, int l, int r) {
        // 停止条件
        if (l == r) {
            return 0;
        }
        // 递归问题分割
        int mid = l + ((r - l) >> 1);

        // return process(nums, l, mid) + process(nums, mid + 1, r) + mergeSort(nums, l,
        // mid, r);
        return process(nums, l, mid) + process(nums, mid + 1, r) + reversePair(nums, l, mid, r);
    }

    // 递归方法的实际执行
    public int mergeSort(int[] nums, int l, int m, int r) {
        int[] storge = new int[r - l + 1];
        int p1 = l;
        int p2 = m + 1;
        int count = 0;
        int ans = 0;

        while ((p1 <= m) && (p2 <= r)) {
            if (nums[p1] < nums[p2]) {

                storge[count] = nums[p1];
                ans = ans + (r - p2 + 1) * nums[p1];
                p1++;
            } else {
                storge[count] = nums[p2];
                p2++;
            }
            count++;
        }

        while (p1 <= m) {
            storge[count++] = nums[p1];
            p1++;
        }
        while (p2 <= r) {
            storge[count++] = nums[p2];
            p2++;
        }
        for (int i = 0; i < r - l + 1; i++) {
            nums[l + i] = storge[i];
        }

        return ans;
    }

    public static int reversePair(int[] nums, int l, int m, int r) {
        int p1 = l;
        int p2 = m + 1;
        int[] storge = new int[r - l + 1];
        int count = 0;

        // 选择从左到右，由大到小
        // 当左边较大，则进行逆序输出，当右边较大则，直接进入，当相等左边直接进入
        while (p1 <= m && p2 <= r) {
            // 右边大的没有逆序，直接进去
            if (nums[p1] < nums[p2]) {
                storge[count++] = nums[p2];
                p2++;
                // 当左边比较大，逆序出现
            } else if (nums[p1] > nums[p2]) {
                storge[count++] = nums[p1];
                for (int i = p2; i <= r; i++) {
                    System.out.println(nums[p1] + " and " + nums[i]);
                }

                p1++;

                // 当左右一样大，先存右边
            } else {
                storge[count++] = nums[p2];
                p2++;
            }
        }

        while (p1 <= m) {
            storge[count++] = nums[p1++];
        }
        while (p2 <= r) {
            storge[count++] = nums[p2++];
        }

        for (int i = 0; i < r - l + 1; i++) {
            nums[l + i] = storge[i];
        }

        return 0;
    }
}
