package LeetCode;

public class Solution05 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null){
            return null;
        }
        if (root.left == null && root.right == null){
            return root;
        } else {
            TreeNode left = root.left;
            TreeNode right = root.right;
            root.left = right;
            root.right = left;
            mirrorTree(root.left);
            mirrorTree(root.right);
        }
        return root;
    }
}
