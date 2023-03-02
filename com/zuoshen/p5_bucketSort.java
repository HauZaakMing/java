package com.zuoshen;

import java.util.ArrayList;
import java.util.Arrays;

public class p5_bucketSort {
    public static void main(String[] args) {
        // int[] nums = dwq.generateRandomArrayP(5, 10, 999);
        // System.out.println("输出原数组");
        // dwq.printArray(nums);
        // int[] copy1 = Arrays.copyOf(nums, nums.length);
        // Arrays.sort(copy1);
        // System.out.println("输出标准答案");
        // dwq.printArray(copy1);
        // bucketSort(nums);
        // System.out.println("输出我的答案");
        // dwq.printArray(nums);

        for (int i = 0; i < 10000; i++) {
            int[] nums = dwq.generateRandomArrayP(5, 10, 999);
            int[] copy1 = Arrays.copyOf(nums, nums.length);
            Arrays.sort(copy1);
            bucketSort(nums);
            if (!Arrays.equals(nums, copy1)) {
                System.out.println("失败");

                dwq.printArray(nums);
                dwq.printArray(copy1);
                break;
            }
        }
        ArrayList<Integer> a = new ArrayList<>();
        System.out.println("success!");

    }

    public static void bucketSort(int[] nums) {
        int maxD = digitCount(nums);

        int[] mediAns = new int[nums.length];
        for (int i = 0; i < maxD; i++) {
            int[] wordF = new int[10];
            for (int num : nums) {
                wordF[getD(num, i)]++;
            }
            for (int j = 1; j < wordF.length; j++) {
                wordF[j] += wordF[j - 1];
            }
            for (int k = nums.length - 1; k >= 0; k--) {
                int d = getD(nums[k], i);
                mediAns[--wordF[d]] = nums[k];
            }
            for (int j = 0; j < nums.length; j++) {
                nums[j] = mediAns[j];
            }
        }
        // System.out.println();
    }

    public static int getD(int num, int p) {
        for (int i = 0; i < p; i++) {
            num = num / 10;
        }
        ;
        num = num % 10;
        return num;
    }

    public static int digitCount(int[] nums) {
        int max = 0;
        for (int i : nums) {
            if (i > max) {
                max = i;
            }
        }
        int ans = 0;
        while (max > 0) {
            max = max / 10;
            ans++;
        }
        return ans;
    }
}
