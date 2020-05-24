package LeetCode;

/**
 * 题目：调整数组顺序使奇数位于偶数之前
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 */

import java.util.Arrays;

public class Solution01 {
    public int[] exchange(int[] nums) {
        int start = 0;
        int end = 0;
        for (int i = 0; i < nums.length; i++){
            if ((nums[i] & 1) == 0){
                start = i;
                end = start + 1;
                break;
            }
        }
        while (end < nums.length){
            if ((nums[end] & 1) == 1){
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end++;
            } else {
                end++;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {5, 4, 2, 3};
        int[] result = new Solution01().exchange(nums);
        System.out.println(Arrays.toString(result));
    }
}
