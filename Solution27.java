package LeetCode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 题目：从上到下打印二叉树I
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 */

public class Solution27 {
    public int[] levelOrder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null){
            return new int[]{};
        } else {
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.add(root);
            while (!queue.isEmpty()){
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
