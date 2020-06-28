package LeetCode;

/**
 * 题目：长度最小的子数组
 */
public class Solution39 {
    public int minSubArrayLen(int s, int[] nums) {
        int res = 0;
        int len = 0;
        if (nums.length ==0 || nums == null){
            return 0;
        }
        for (int start = 0, end = 0; start < nums.length;) {
            if (res < s){
                if (end >= nums.length){
                    break;
                }
                res += nums[end];
                end++;
            } else {
                if (len == 0){
                    len = end - start;
                } else {
                    len = (end - start) < len ? (end - start) : len;
                }
                res -= nums[start];
                start++;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 2, 4, 7};
        int res = new Solution39().minSubArrayLen(7, nums);
        System.out.println(res);
    }
}
