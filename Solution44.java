package LeetCode;

/**
 * 题目：将有序数组转换成二叉搜索树
 */
public class Solution44 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0){
            return null;
        }
        return sort(nums, 0, nums.length - 1);
    }
    public TreeNode sort(int[] nums, int start, int end){
        int len = end - start + 1;
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        if (len <= 2){
            if (len == 2){
                node.left = new TreeNode(nums[mid - 1]);
            }
        } else {
            node.left = sort(nums, start, mid - 1);
            node.right = sort(nums, mid + 1, end);
        }
        return node;
    }
}
