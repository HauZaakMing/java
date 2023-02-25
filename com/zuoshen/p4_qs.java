package com.zuoshen;

import java.util.Arrays;

public class p4_qs {

    public static void main(String[] args) {

        for (int i = 0; i < 1000; i++) {
            int[] nums = dwq.generateRandomArray(10, 5, 15);
            int[] copy = Arrays.copyOf(nums, nums.length);
            Arrays.sort(copy);
            process(nums, 0, nums.length - 1);
            if (!Arrays.equals(nums, copy)) {
                System.out.println("出错了");

                System.out.println("标准答案：");
                for (int num : copy) {

                    System.out.print(num + " ");
                }
                System.out.println();
                System.out.println("我的答案：");
                for (int num : nums) {

                    System.out.print(num + " ");
                }
                System.out.println();
            }
        }
        System.out.println("全对！！！");

        // System.out.println("排序前：");
        // for (int i : nums) {

        // System.out.print(i + " ");
        // }
        // System.out.println();
        // System.out.println("标准答案：");
        // for (int i : copy) {

        // System.out.print(i + " ");
        // }
        // System.out.println();

        // System.out.println("排序后：");
        // for (int i : nums) {
        // System.out.print(i + " ");
        // }
    }

    public static void process(int[] nums, int l, int r) {
        if (r <= l) {
            return;
        }

        // int mid = l + ((r - l) >> 1);

        int margin[] = quickSort(nums, l, r);
        process(nums, l, margin[0]);
        process(nums, margin[1], r);

    }

    public static int[] quickSort(int[] nums, int l, int r) {
        int random = (int) (Math.random()) * (r - l + 1);
        swap(nums, r - 1, random + l);
        int key = nums[r];
        int minMargin = l - 1;
        int maxMargin = r + 1;
        int p = l;
        // 指针从左往右扫描
        // 要是大于key值，置换maxMargin前一个，然后，再验证那个值
        // 要是小于key值，置换minMargin后一个，然后，继续往后
        // 要是等于key值，往后
        while (p < maxMargin) {
            if (nums[p] > key) {
                swap(nums, p, maxMargin - 1);
                maxMargin--;
            } else if (nums[p] < key) {
                swap(nums, p, minMargin + 1);
                minMargin++;
                p++;
            } else {
                p++;
            }
        }
        return new int[] { minMargin, maxMargin };
    }

    public static void swap(int[] nums, int p1, int p2) {
        int temp = nums[p1];
        nums[p1] = nums[p2];
        nums[p2] = temp;
    }

}
