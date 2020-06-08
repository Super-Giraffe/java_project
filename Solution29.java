package LeetCode;

import java.util.*;

/**
 * 题目：从上到下打印二叉树III
 * 从上到下按层打印二叉树，，每一层打印到一行。
 */
public class Solution29 {
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
            //layer为当前层的层数
            int layer = 1;
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
                    if (layer % 2 == 0){
//                        int i = 0;
//                        int j = list.size() - 1;
//                        while (i < j){
//                            int temp = list.get(i);
//                            list.set(i, list.get(j));
//                            list.set(j, temp);
//                            i++;
//                            j--;
//                        }
                        Collections.reverse(list);
                    }
                    res.add(list);
                    list = new ArrayList<>();
                    nowNum = nextNum;
                    nextNum = 0;
                    layer++;
                }
            }
        }
        return res;
    }
}
