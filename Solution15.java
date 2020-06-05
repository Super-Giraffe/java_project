package LeetCode;

/**
 * 题目：盛最多水的容器
 */

public class Solution15 {
//    public int maxArea(int[] height) {
//        int max = 0;
//        for (int i = 0; i < height.length; i++) {
//            for (int j = i + 1; j < height.length; j++){
//                int res = min(height[i], height[j]) * (j - i);
//                if (res > max){
//                    max = res;
//                }
//            }
//        }
//        return max;
//    }
//    public int min(int x, int y){
//        return x < y ? x : y;
//    }
    public int maxArea(int[] height) {
        int max = 0;
        int start = 0;
        int end = height.length - 1;
        while (start < end){
            int res = Math.min(height[start], height[end]) * (end - start);
            max = Math.max(max, res);
            if (height[start] < height[end]){
                start++;
            } else {
                end--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1,8,6,2,5,4,8,3,7};
        int max = new Solution15().maxArea(nums);
        System.out.println(max);
    }
}
