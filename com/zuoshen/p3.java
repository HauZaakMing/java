package com.zuoshen;

public class p3 {

    public static void main(String[] args) {
        for (int i = 0; i < 50000; i++) {
            p3 demo = new p3();
            demo.t2();
        }

    }

    public void t1() {
        // 两数出现次数为奇，其余为偶，找这两个数
        int[] nums = { 1, 1, 2, 2, 5, 4 };
        int e = 0;
        for (int num : nums) {
            e = e ^ num;
        }
        // 找出最右边的1
        int right1 = e & (~e + 1);
        // e这里存的是a^b,
        int e2 = e;
        // 通过right1 & num，我们可以将a，b分为两组，任意取其一
        for (int num : nums) {
            if ((right1 & num) == 0) {
                e2 = e2 ^ num;
            }

        }
        System.out.println(e2 + "  " + (e ^ e2));
    }

    public void t2() {
        // 寻找局部最小
        // int[] nums = { 4, 3, 7, 5, 2, 6 };
        int[] nums = dwq.generateRandomArray(5, 10, 100);
        for (int i : nums) {
            System.out.print(i + " ");
        }
        System.out.println();
        // int[] nums = { 4, 3, 2, 1, 2, 3 };
        // 先检查左右
        int left = 0;
        int right = nums.length - 1;
        if (nums[left] < nums[left + 1]) {
            System.out.println(left);
            return;
        }
        if (nums[right] < nums[right - 1]) {
            System.out.println(right);
            return;
        }
        while (left != right) {
            int mid = (left + right) / 2;
            if (nums[mid] < nums[mid - 1] && nums[mid] < nums[mid + 1]) {
                System.out.println(mid);
                return;
            } else if (nums[mid - 1] > nums[mid]) {
                left = mid;
            } else {
                right = mid;
            }
        }

    }
}
