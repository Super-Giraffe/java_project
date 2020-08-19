package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution61_70 {
    public static void main(String[] args) {
        int res = new Solution70().countSubstrings("   ");
        System.out.println(res);
    }
}

//相同的树
class Solution61{
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null){
            if (q == null){
                return true;
            } else {
                return false;
            }
        } else {
            if (q == null){
                return false;
            } else {
                if (p.val == q.val){
                    return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
                } else {
                    return false;
                }
            }
        }
    }
}

class Solution62{
    public char firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        if (s == null || s.length() == 0){
            return ' ';
        }
        char[] chars = s.toCharArray();
        for (char c : chars){
            if (map.containsKey(c)){
                map.put(c, (map.get(c) + 1));
            } else {
                map.put(c, 1);
            }
        }
        for (char c : chars){
            if (map.get(c) == 1){
                return c;
            }
        }
        return ' ';
    }
}

//连续子数组的最大和
class Solution63{
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        for(int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1], 0);
            res = Math.max(res, nums[i]);
        }
        return res;
    }
}

//最小的k个数
class Solution64{
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] res = new int[k];
        Arrays.sort(arr);
        for (int i = 0; i < k; i++){
            res[i] = arr[i];
        }
        return res;
    }
}

//数组中出现超过一半的数字
class Solution65{
    public int majorityElement(int[] nums) {
        int x = 0, votes = 0;
        for(int num : nums){
            if(votes == 0) x = num;
            votes += num == x ? 1 : -1;
        }
        return x;
    }
}

class Solution66{
    List<String> res = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        StringBuffer buffer = new StringBuffer();
        process(s, 0, buffer, 0);
        return res;
    }

    public void process(String str, int start, StringBuffer buffer, int count){
        for (int i = 1; i <= 3; i++){
            String flag;
            if (count == 3 && (start + i) == str.length()){
                flag = str.substring(start, start + i);
                if (i == 1 && Integer.valueOf(flag) == 0){
                    buffer.append(flag);
                    res.add(buffer.toString());
                    buffer.delete(buffer.length() - i, buffer.length());
                } else {
                    if (Integer.valueOf(flag) >= (int)Math.pow(10.0, i - 1) && Integer.valueOf(flag) <= 255){
                        buffer.append(flag);
                        res.add(buffer.toString());
                        buffer.delete(buffer.length() - i, buffer.length());
                    }
                }
                return;
            } else if (count > 3 || start + i > str.length()){
                return;
            }
            flag = str.substring(start, start + i);
            if (i == 1 && Integer.valueOf(flag) == 0){
                buffer.append(flag + ".");
                process(str, start + i, buffer, count + 1);
                buffer.delete(buffer.length() - i - 1, buffer.length());
            } else {
                if (Integer.valueOf(flag) >= (int)Math.pow(10, i - 1) && Integer.valueOf(flag) <= 255){
                    buffer.append(flag + ".");
                    process(str, start + i, buffer, count + 1);
                    buffer.delete(buffer.length() - i - 1, buffer.length());
                }
            }
        }
    }
}

//计数二进制子串
class Solution67{
    public int countBinarySubstrings(String s) {
        int res = 0;
        char[] chars = s.toCharArray();
        List<Integer> list = new ArrayList<>();
        char flag = '0';
        int count = 0;
        for (int i = 0; i < chars.length;){
            if (chars[i] == flag){
                count++;
                i++;
            } else {
                list.add(count);
                count = 0;
                flag = chars[i];
            }
        }
        list.add(count);
        for (int i = 0; i < list.size() - 1; i++){
            res += Math.min(list.get(i), list.get(i + 1));
        }
        return res;
    }
}

//被围绕的区域
class Solution68{
    int n, m;
    public void solve(char[][] board) {
        n = board.length;
        if (n == 0) {
            return;
        }
        m = board[0].length;
        for (int i = 0; i < n; i++) {
            dfs(board, i, 0);
            dfs(board, i, m - 1);
        }
        for (int i = 1; i < m - 1; i++) {
            dfs(board, 0, i);
            dfs(board, n - 1, i);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void dfs(char[][] board, int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= m || board[x][y] != 'O') {
            return;
        }
        board[x][y] = 'A';
        dfs(board, x + 1, y);
        dfs(board, x - 1, y);
        dfs(board, x, y + 1);
        dfs(board, x, y - 1);
    }
}

//平衡二叉树
class Solution69{
    public boolean isBalanced(TreeNode root) {
        if (root != null){
            return isBalanced(root.left) && isBalanced(root.right) && Math.abs(depth(root.left) - depth(root.right)) <= 1;
        } else {
            return true;
        }
    }
    public int depth(TreeNode node){
        if (node != null){
            return Math.max(depth(node.left), depth(node.right)) + 1;
        } else {
            return 1;
        }
    }
}

//有序链表转换二叉搜索树
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> nodelist = new ArrayList<>();
        while (head != null){
            nodelist.add(head.val);
            head = head.next;
        }
        TreeNode node = build(0, nodelist.size() - 1, nodelist);
        return node;
    }
    public TreeNode build(int start, int end, List<Integer> nodelist){
        if (start > end){
            return null;
        }
        TreeNode node = new TreeNode(nodelist.get((start + end) / 2));
        node.left = build(start, (start + end) / 2 - 1, nodelist);
        node.right = build((start + end) / 2 + 1, end, nodelist);
        return node;
    }
}

//回文子串
class Solution70 {
    int res = 1;
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length - 1; i++){
            res += process(i - 1, i + 1, c);
            if (c[i] == c[i + 1]){
                res += process(i - 1, i + 2, c);
            }
        }
        return res;
    }
    public int process(int start, int end, char[] c){
        while (start >= 0 && end < c.length && c[start] == c[end]){
            start--;
            end++;
        }
        return (end - start) / 2;
    }
}