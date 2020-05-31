package LeetCode;

public class Solution07 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return false;
        } else {
            if (root.left == null && root.right == null){
                return true;
            } else {
                return nodeEqual(root.left, root.right);
            }
        }
    }
    public boolean nodeEqual(TreeNode left, TreeNode right){
        if (left == null){
            if (right == null){
                return true;
            } else {
                return false;
            }
        } else {
            if (right == null){
                return false;
            } else {
                if (left.val == right.val) {
                    return nodeEqual(left.left, right.right) && nodeEqual(left.right, right.left);
                } else {
                    return false;
                }
            }
        }
    }
}
