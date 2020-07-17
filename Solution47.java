package LeetCode;

/**
 * 题目：搜索插入的位置
 */
public class Solution47 {
    public int searchInsert(int[] nums, int target) {
        int begin = 0;
        int end = nums.length - 1;
        while (begin <= end){
            int mid = (begin + end) / 2;
            if (nums[mid] == target){
                return mid;
            } else {
                if (nums[mid] < target){
                    begin = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        int index = 0;
        for (int num : nums){
            if (num > target){
                return index;
            } else {
                index++;
            }
        }
        return 0;
    }
}
