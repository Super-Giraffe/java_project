package LeetCode;

import java.util.Arrays;

/**
 * 题目：等式方程的可满足性
 *
 * 给定一个由表示变量之间关系的字符串方程组成的数组，每个字符串方程 equations[i] 的长度为 4，并采用两种不同的形式之一："a==b" 或 "a!=b"。在这里，a 和 b 是小写字母（不一定不同），表示单字母变量名。
 *
 * 只有当可以将整数分配给变量名，以便满足所有给定的方程时才返回 true，否则返回 false。
 *
 */
public class Solution18 {
    public boolean equationsPossible(String[] equations) {
        int length = equations.length;
        int[] parent = new int[26];
        //创建一个数组每个元素表示一个节点，并且元素的值指的是连接的下一个节点的索引，初始化为自身的索引
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }
        for (String str : equations) {
            if (str.charAt(1) == '=') {
                int index1 = str.charAt(0) - 'a';
                int index2 = str.charAt(3) - 'a';
                //将索引为index1和index2的节点连接在一起，即将索引为index1的节点所在链的最后一个节点指向索引为index2的节点所在链的最后一个节点
                union(parent, index1, index2);
            }
        }
        for (String str : equations) {
            if (str.charAt(1) == '!') {
                int index1 = str.charAt(0) - 'a';
                int index2 = str.charAt(3) - 'a';
                //判断索引为index1的节点所在链的最后一个节点是否与引为index2的节点所在链的最后一个节点相同
                //若相同，则这两个节点在一条链上 return true，反之则不在同一条链上 return false
                if (find(parent, index1) == find(parent, index2)) {
                    return false;
                }
            }
        }
        return true;
    }

    public void union(int[] parent, int index1, int index2) {
        //将索引为index1的节点所在链的最后一个节点指向索引为index2的节点所在链的最后一个节点
        parent[find(parent, index1)] = find(parent, index2);
    }

    public int find(int[] parent, int index) {
        //判断是否该节点是否是终结节点，是则返回该节点索引，反之将记录该节点下一个节点的索引，存入index，再将下一个节点的值(即下一个节点的后一个节点的索引)
        while (parent[index] != index) {
            //parent[index] = parent[parent[index]];
            //index = parent[index];
            index = parent[index];
        }
        return index;
    }
}
