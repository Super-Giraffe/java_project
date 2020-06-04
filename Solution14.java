package LeetCode;

public class Solution14 {
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int[] res = new int[nums.length];
        left[0] = 1;
        right[right.length - 1] = 1;
        for (int i = 1; i < left.length; i++){
            left[i] = left[i - 1] * nums[i - 1];
        }
        for (int j = right.length - 2; j >= 0; j--) {
            right[j] = right[j + 1] * nums[j + 1];
        }
        for (int k = 0; k < nums.length; k++){
            res[k] = left[k] * right[k];
        }
        return res;
    }
}
