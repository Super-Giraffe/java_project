package LeetCode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 题目：从上到下打印二叉树II
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 */
public class Solution28 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null){
            return new ArrayList<>();
        } else {
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.add(root);
            //nowNum为当前层的节点数
            int nowNum = 1;
            //nextNum为下一层的节点数
            int nextNum = 0;
            while (!queue.isEmpty()){
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null){
                    queue.add(node.left);
                    nextNum++;
                }
                if (node.right != null){
                    queue.add(node.right);
                    nextNum++;
                }
                nowNum--;
                //当当前层的节点都遍历完后进入下一层，即将下一层的节点数设置为当前层的节点数，下一层节点数清零，并重新创建一个Lits记录数据
                if (nowNum == 0){
                    res.add(list);
                    list = new ArrayList<>();
                    nowNum = nextNum;
                    nextNum = 0;
                }
            }
        }
        return res;
    }
}
