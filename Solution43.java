package LeetCode;

/**
 * 题目：有序矩阵中第K小的矩阵
 */
public class Solution43 {
    public int kthSmallest(int[][] matrix, int k) {
        int[] res = new int[matrix.length * matrix[0].length];
        res = matrix[0];
        for (int i = 1; i < matrix.length; i++){
            res = sort(res, matrix[i]);
        }
        return res[k - 1];
    }
    public int[] sort(int[] nums1, int[] nums2){
        int[] res = new int[nums1.length + nums2.length];
        int flag = 0;
        int i, j;
        for (i = 0, j = 0; i < nums1.length && j < nums2.length;){
            if (nums1[i] < nums2[j]){
                res[flag] = nums1[i];
                i++;
                flag++;
            } else {
                res[flag] = nums2[j];
                j++;
                flag++;
            }
        }
        if (i < nums1.length){
            for (int k = i; k < nums1.length; k++){
                res[flag] = nums1[k];
                flag++;
            }
        }
        if (j < nums2.length){
            for (int k = j; k < nums2.length; k++){
                res[flag] = nums2[k];
                flag++;
            }
        }
        return res;
    }
}
