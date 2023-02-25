package com.zuoshen;

import java.util.Arrays;

public class p5_hs {

    public static void main(String[] args) {

        for (int i = 0; i < 500000; i++) {
            int[] nums = dwq.generateRandomArray(10, 5, 15);
            // dwq.printArray(nums);
            // int[] nums = new int[] { 6, 4, 0, 7, 1, -1, 3, -3, -10, -5 };
            int[] copy = Arrays.copyOf(nums, nums.length);
            int[] copy1 = Arrays.copyOf(nums, nums.length);
            Arrays.sort(copy);
            heapSort(copy1);
            if (!Arrays.equals(copy1, copy)) {
                dwq.printArray(nums);
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
    }

    public static void heapSort(int[] nums) {
        int heapsize = 0;

        // 第一步，建一个大顶堆
        // 每进一个都要进行上浮
        while (heapsize + 1 != nums.length) {
            heapsize++;
            int p = heapsize;

            while (p != 0) {

                if (nums[(p - 1) >> 1] < nums[p]) {
                    swap(nums, p, (p - 1) >> 1);
                    p = (p - 1) >> 1;
                } else {
                    break;
                }
            }

        }

        // 开始出顶
        while (heapsize >= 0) {
            swap(nums, heapsize, 0);
            heapsize--;
            // 换完之后开始下沉
            int p = 0;
            while (true) {
                int l = (p << 1) + 1;
                int r = (p << 1) + 2;

                // 推出条件，左边越界就是叶子结点，右边越界，左边可以比较一下
                if (l > heapsize) {
                    break;
                }
                if (r > heapsize) {
                    if (nums[l] > nums[p]) {
                        swap(nums, l, p);
                    }
                    break;
                }

                // 要是左右叶子还在
                if ((nums[l] > nums[r]) && (nums[l] > nums[p])) {
                    swap(nums, l, p);
                    p = l;
                } else if ((nums[l] <= nums[r]) && (nums[r] > nums[p])) {
                    swap(nums, r, p);
                    p = r;
                } else {
                    // 左右叶子都在，但是都比你小
                    break;
                }

            }

        }

    }

    public static void swap(int[] nums, int p1, int p2) {
        int temp = nums[p1];
        nums[p1] = nums[p2];
        nums[p2] = temp;
    }
}
