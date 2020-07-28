package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题目：四数之和
 */
public class Solution50 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++){
            for (int j = nums.length - 1; j > i + 2; j--){
                int start = i + 1;
                int end = j - 1;
                while (start < end){
                    if (nums[i] + nums[j] + nums[start] + nums[end] == target){
                        List<Integer> numbers = new ArrayList<>();
                        numbers.add(nums[i]);
                        numbers.add(nums[start]);
                        numbers.add(nums[end]);
                        numbers.add(nums[j]);
                        if (!res.contains(numbers)){
                            res.add(numbers);
                        }
                        start++;
                        end--;
                    }
                    if (nums[i] + nums[j] + nums[start] + nums[end] < target){
                        start++;
                    }
                    if (nums[i] + nums[j] + nums[start] + nums[end] > target){
                        end--;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-5,5,4,-3,0,0,4,-2,4};
        List<List<Integer>> lists = new Solution50().fourSum(nums, 4);
        for (List list : lists){
            System.out.println(list);
        }
    }
}
