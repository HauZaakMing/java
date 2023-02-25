package com.sword2offer;

public class q_6 {
    Integer[] nums = { 3, 2, 4 };
    Integer target = 6;

    public int[] solution() {

        int left = 0;
        int right = nums.length - 1;
        while (left != right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                break;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[] { left, right };
    }
}
