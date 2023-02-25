package com.zuoshen;

public class dwq {

    // 用来生成相邻不相等的数组
    public static int[] generateRandomArray(int minSize, int maxSize, int maxValue) {
        int[] arr = new int[(int) (Math.random() * (maxSize - minSize)) + minSize];
        arr[0] = (int) (Math.random() * maxValue) - (int) (Math.random() * maxValue);
        for (int i = 1; i < arr.length; i++) {
            do {
                arr[i] = (int) (Math.random() * maxValue) - (int) (Math.random() * maxValue);
            } while (arr[i] == arr[i - 1]);
        }
        return arr;
    }

    public static int[] generateRandomArrayP(int minSize, int maxSize, int maxValue) {
        int[] arr = new int[(int) (Math.random() * (maxSize - minSize)) + minSize];
        arr[0] = (int) (Math.random() * maxValue);
        for (int i = 1; i < arr.length; i++) {
            do {
                arr[i] = (int) (Math.random() * maxValue);
            } while (arr[i] == arr[i - 1]);
        }
        return arr;
    }

    public static void printArray(int[] nums) {
        System.out.println("开始打印数组");
        for (int i : nums) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("=====================");
    }

    public static void hi() {
        System.out.println("hi");
    }

}
