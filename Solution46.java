package LeetCode;

/**
 * 题目：路径总和
 */
public class Solution46 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null){
            return false;
        }
        return hasPath(root, root.val, sum);
    }
    public boolean hasPath(TreeNode node, int now, int goal){
        if (now == goal && node.right == null && node.left == null){
            return true;
        } else {
            if (node.left == null){
                if (node.right == null){
                    return false;
                } else {
                    return hasPath(node.right, now + node.right.val, goal);
                }
            } else {
                if (node.right == null){
                    return hasPath(node.left, now + node.left.val, goal);
                } else {
                    return hasPath(node.left, now + node.left.val, goal) || hasPath(node.right, now + node.right.val, goal);
                }
            }
        }
    }
}
